package com.treinamento.course.controller;

import com.treinamento.course.entidade.User;
import com.treinamento.course.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<User> findA(){
        User u = new User(1L,"Maria", "maria@gmail.com", "999999", "1212112");
        return ResponseEntity.ok().body(u);
    }

  /*  @GetMapping
    public ResponseEntity <User> listAll (User user){
        return userService.listAll(user);

    }*/

}
