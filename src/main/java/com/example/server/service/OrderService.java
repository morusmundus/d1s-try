package com.example.server.service;

import com.example.server.entity.Orders;
import com.example.server.repositories.Repository;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends AbstractService<Orders> {
    public OrderService(Repository<Orders> repository) {
        super(repository);
    }

}