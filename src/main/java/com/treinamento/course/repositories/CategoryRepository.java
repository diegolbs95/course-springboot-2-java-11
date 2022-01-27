package com.treinamento.course.repositories;

import com.treinamento.course.entidade.Category;
import com.treinamento.course.entidade.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
