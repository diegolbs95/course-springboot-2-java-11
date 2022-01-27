package com.treinamento.course.service.exception;

public class ResourceNotFoundException extends  RuntimeException{

    public ResourceNotFoundException (Long e){
        super("Id " + e + " nao existe");
    }
}
