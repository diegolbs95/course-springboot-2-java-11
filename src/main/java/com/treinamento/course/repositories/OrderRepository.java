package com.treinamento.course.repositories;

import com.treinamento.course.entidade.Order;
import com.treinamento.course.entidade.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
