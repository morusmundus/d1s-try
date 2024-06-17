package com.example.server.service;

import com.example.server.dto.UserInfoDto;
import com.example.server.dto.UserOrdersDto;
import com.example.server.dto.chart.LineChartDto;
import com.example.server.entity.Orders;
import com.example.server.repositories.OrderRepository;
import com.example.server.repositories.ReceiptRepository;
import com.example.server.repositories.Repository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService extends AbstractService<Orders> {
    public OrderService(Repository<Orders> repository) {
        super(repository);
    }

    public List<UserOrdersDto> findAllUsersOrders(Long userId){
        return ((OrderRepository) repository).findAllUsersOrders(userId);
    }
}