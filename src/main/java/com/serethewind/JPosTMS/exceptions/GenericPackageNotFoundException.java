package com.serethewind.JPosTMS.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GenericPackageNotFoundException extends RuntimeException{


    public GenericPackageNotFoundException(String message){
        super(message);
    }
}
