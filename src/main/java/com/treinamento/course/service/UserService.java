package com.treinamento.course.service;

import com.treinamento.course.entidade.User;
import com.treinamento.course.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<User> listAll (User user){
        return ResponseEntity.ok().body(user);
    }
}
