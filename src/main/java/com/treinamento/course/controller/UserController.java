package com.treinamento.course.controller;

import com.treinamento.course.entidade.User;
import com.treinamento.course.repositories.UserRepository;
import com.treinamento.course.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;
import org.springframework.web.servlet.mvc.method.annotation.UriComponentsBuilderMethodArgumentResolver;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.annotation.HttpConstraint;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> listAll (){
        List<User> list = userService.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{userId}")
    public ResponseEntity<User> findById (@PathVariable Long userId){
        User obj = userService.findById(userId);
        return ResponseEntity.ok().body(obj);
    }
    @DeleteMapping(value = "/{userId}")
    public ResponseEntity<Void> delete (@PathVariable Long userId){
        userService.delete(userId);
        return ResponseEntity.noContent().build();
    }
    @PostMapping
    public ResponseEntity<User> insert (@RequestBody User obj){
        obj = userService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
    @PutMapping(value = "/{id}")
    public User update (@PathVariable Long id,@RequestBody User obj){
        User userAtual = userService.update(id,obj);
        return userService.insert(userAtual);
    }



}
