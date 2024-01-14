package com.example.server.service;

import com.example.server.dto.chart.LineChartDto;
import com.example.server.entity.Book;
import com.example.server.entity.Orders;
import com.example.server.entity.Receipt;
import com.example.server.entity.User;
import com.example.server.dto.BookOrderDto;
import com.example.server.repositories.ReceiptRepository;
import com.example.server.repositories.Repository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReceiptService extends AbstractService<Receipt> {
    private final BookService bookService;

    public ReceiptService(Repository<Receipt> repository, BookService bookService) {
        super(repository);
        this.bookService = bookService;
    }

    public void createReceipt(Long userId, List<BookOrderDto> bookIds) {
        Receipt receipt = repository.save(new Receipt(new User(userId)));

        List<Orders> mappedOrders = bookIds.stream()
                .map(o -> {
                    bookService.decreaseQuantity(o.getId(), o.getQuantity());
                    return Orders.builder()
                        .book(Book.builder().id(o.getId()).build())
                        .receipt(receipt)
                        .productQuantity(o.getQuantity())
                        .build();
                })
                .collect(Collectors.toCollection(ArrayList::new));

        receipt.setCreationTime(Timestamp.valueOf(LocalDateTime.now()));
        receipt.setPositions(mappedOrders);

        repository.save(receipt);
    }

    public List<LineChartDto> findPurchaseCountForLastDays(int days){
        return ((ReceiptRepository) repository).findPurchaseQuantityByDate(Timestamp.valueOf(LocalDateTime.now().minusDays(days)));
    }
}