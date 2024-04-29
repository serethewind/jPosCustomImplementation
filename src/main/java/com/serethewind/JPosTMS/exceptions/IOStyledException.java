package com.serethewind.JPosTMS.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class IOStyledException extends  RuntimeException{

    public IOStyledException(String message){
        super(message);
    }
}
