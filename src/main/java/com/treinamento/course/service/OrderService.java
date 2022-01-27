package com.treinamento.course.service;

import com.treinamento.course.entidade.Order;
import com.treinamento.course.entidade.User;
import com.treinamento.course.repositories.OrderRepository;
import com.treinamento.course.repositories.UserRepository;
import org.aspectj.weaver.ast.Or;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserService userService;

    public List<Order> findAll () {
        return orderRepository.findAll();
    }

    public Order additional(Order order) {
        Long userId = order.getClient().getId();
        User user = userService.findById(userId);

        order.setClient(user);

        return orderRepository.save(order);
    }

    public Order findById (Long id) {
        Optional<Order> obj = orderRepository.findById(id);
        return obj.get();
    }

    public void delete (Long id) {

        orderRepository.deleteById(id);
    }

}
