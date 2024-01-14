package com.example.server.repositories;

import com.example.server.dto.chart.LineChartDto;
import com.example.server.entity.Receipt;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ReceiptRepository extends Repository<Receipt> {

    @Query("SELECT new com.example.server.dto.chart.LineChartDto(r.creationTime as date, SUM(o.productQuantity) as quantity) " +
            "FROM Receipt r " +
            "JOIN r.positions o " +
            "WHERE r.creationTime >= :startDate " +
            "GROUP BY DATE(r.creationTime)")
    List<LineChartDto> findPurchaseQuantityByDate(@Param("startDate") Date startDate);
}
