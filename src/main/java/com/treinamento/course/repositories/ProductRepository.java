package com.treinamento.course.repositories;

import com.treinamento.course.entidade.Category;
import com.treinamento.course.entidade.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
