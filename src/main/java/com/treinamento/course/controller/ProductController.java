package com.treinamento.course.controller;

import com.treinamento.course.entidade.Product;
import com.treinamento.course.entidade.User;
import com.treinamento.course.service.ProductService;
import com.treinamento.course.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<List<Product>> listAll (){
        List<Product> list = service.findAll();
        return ResponseEntity.ok().body(list);

    }
    @GetMapping("/{userId}")
    public ResponseEntity<Product> findById (@PathVariable Long userId){
        Product obj = service.findById(userId);
        return ResponseEntity.ok().body(obj);
    }
}
