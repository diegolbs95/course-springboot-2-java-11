package com.treinamento.course.service;

import com.treinamento.course.entidade.Category;
import com.treinamento.course.entidade.Order;
import com.treinamento.course.entidade.User;
import com.treinamento.course.repositories.CategoryRepository;
import com.treinamento.course.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll () {
        return categoryRepository.findAll();
    }

    public Category findById (Long id) {
        Optional<Category> obj = categoryRepository.findById(id);
        return obj.get();
    }
    public Category adicionar (Category category){
        var obj = categoryRepository.save(category);
        return obj;
    }

    public void delete (Long id) {
        categoryRepository.deleteById(id);
    }

}
