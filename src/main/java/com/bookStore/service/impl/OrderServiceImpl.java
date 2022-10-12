package com.bookStore.service.impl;

import com.bookStore.data.entity.Book;
import com.bookStore.data.entity.Order;
import com.bookStore.data.repository.OrderRepository;
import com.bookStore.service.BookService;
import com.bookStore.service.OrderService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {

    final OrderRepository orderRepository;
    final BookService bookService;
//    final Logger logger = (Logger) LoggerFactory.getLogger(OrderService.class);


    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order putAnOrder(List<Integer > bookIdList, String userName) {

        List<Optional<Book>> bookList = bookIdList.stream()
                .map(bookService::getOneBook).collect(Collectors.toList());


        Double totalPrice = bookList.stream()
                .map(O -> O.map(Book::getPrice).orElse(0.0))
                .reduce(0.0, Double::sum);

        Order order=new Order();
        order.setUserName(userName);
        order.setTotalPrice(totalPrice);
        order.setBookIdList(bookIdList);

        return orderRepository.save(order);
    }
}
