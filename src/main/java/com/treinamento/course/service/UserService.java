package com.treinamento.course.service;

import com.treinamento.course.controller.exception.DataBaseException;
import com.treinamento.course.entidade.User;
import com.treinamento.course.repositories.UserRepository;
import com.treinamento.course.service.exception.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll (){
        return userRepository.findAll();
    }

    public User findById (Long id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
    public void delete (Long id) {
        try {
            userRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }catch (DataIntegrityViolationException e){
            throw new DataBaseException(e.getMessage());
        }
    }
    public User insert (User obj){
        return userRepository.save(obj);
    }
    public User update (Long id, User user){
       try {
           User userAtual = userRepository.getById(id);
           BeanUtils.copyProperties(user, userAtual, "id");
           return userRepository.save(userAtual);
       }catch (EntityNotFoundException e){
          throw new ResourceNotFoundException(id);
       }
    }

}
