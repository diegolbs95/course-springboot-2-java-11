package com.treinamento.course.controller;

import com.treinamento.course.entidade.User;
import com.treinamento.course.repositories.UserRepository;
import com.treinamento.course.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> listAll (){
        return ResponseEntity.ok().body(userService.findAll());
    }

    @GetMapping("/{userId}")
    public User findById (@PathVariable Long userId){
        return userService.findById(userId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User adicionar (@RequestBody User user){
        return userService.adicionar(user);
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable Long userId){
        userService.delete(userId);
    }

}
