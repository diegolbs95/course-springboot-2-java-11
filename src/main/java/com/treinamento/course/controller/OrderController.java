package com.treinamento.course.controller;

import com.treinamento.course.entidade.Order;
import com.treinamento.course.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> listAll () {
        return ResponseEntity.ok().body(orderService.findAll());
    }

    @GetMapping("/{orderId}")
    public Order findById (@PathVariable Long orderId) {
        return orderService.findById(orderId);
    }

  /*  @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order adicionar (@RequestBody Order order) {
        return orderService.additional(order);
    }*/

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable Long userId) {
        orderService.delete(userId);
    }
}
