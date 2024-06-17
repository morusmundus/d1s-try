package com.example.server.repositories;

import com.example.server.dto.UserOrdersDto;
import com.example.server.dto.chart.LineChartDto;
import com.example.server.dto.chart.SalesAnalisysDto;
import com.example.server.entity.Orders;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends Repository<Orders> {
    @Query("SELECT new com.example.server.dto.UserOrdersDto(r.id AS receipt_id, b.id AS book_id, u.id AS user_id, r.creationTime AS creation_time, o.productQuantity AS quantity, b.title AS title, b.price AS price) " +
            "from Orders o " +
            "JOIN o.receipt r " +
            "JOIN o.book b " +
            "JOIN r.user u " +
            "WHERE u.id = :userId " +
            "ORDER BY receipt_id ")
    List<UserOrdersDto> findAllUsersOrders(@Param("userId") Long userId);

    @Query("SELECT new com.example.server.dto.chart.SalesAnalisysDto(r.id AS receipt_id, b.id AS book_id, r.creationTime AS creation_time, " +
            "SUM(b.price * o.productQuantity) AS money, b.title AS title) from Orders o " +
            "JOIN o.receipt r " +
            "JOIN o.book b " +
            "WHERE r.creationTime BETWEEN :startDate AND :endDate " +
            "Group by book_id,  receipt_id ")
    List<SalesAnalisysDto> getXYZAnalisys(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
