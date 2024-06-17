package com.example.server.controller;

import com.example.server.entity.UserPrincipal;
import com.example.server.dto.BookOrderDto;
import com.example.server.repositories.OrderRepository;
import com.example.server.service.OrderService;
import com.example.server.service.ReceiptService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReceiptController {
    private final ReceiptService receiptService;
    private final OrderService orderService;

    @PostMapping("/orders")
    public ResponseEntity<Object> orderBooks(
            @AuthenticationPrincipal UserPrincipal principal,
            @RequestBody List<BookOrderDto> itemsId
    ) {
        receiptService.createReceipt(principal.getUserId(), itemsId);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/user-orders")
    public Object getUserOrdersInfo(@AuthenticationPrincipal UserPrincipal user) {
        return orderService.findAllUsersOrders(user.getUserId());
    }

}
