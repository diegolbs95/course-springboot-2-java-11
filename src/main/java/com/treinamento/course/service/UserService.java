package com.treinamento.course.service;

import com.treinamento.course.entidade.User;
import com.treinamento.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll (){
        return userRepository.findAll();
    }

    public  User adicionar (User user){
        return userRepository.save(user);
    }

    public User findById (Long id){
        Optional<User> obj = userRepository.findById(id);
        return obj.get();
    }

    public void delete (Long id){
         userRepository.deleteById(id);
    }

}
