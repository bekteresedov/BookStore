package com.bookStore.controller;

import com.bookStore.data.dto.BookOrderRequest;
import com.bookStore.data.entity.Order;
import com.bookStore.service.OrderService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders/")
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class OrderController {

    final OrderService orderService;


    @GetMapping("getAll")
    public ResponseEntity<List<Order>>getAllOrders(){
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @PostMapping
    public ResponseEntity<Order>putAndOrder(@RequestBody BookOrderRequest bookOrderRequest){

        Order order = orderService.putAnOrder(bookOrderRequest.getBookIdList(), bookOrderRequest.getUserName());
        return ResponseEntity.ok(order);
    }
}
