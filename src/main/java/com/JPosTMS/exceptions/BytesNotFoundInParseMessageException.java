package com.JPosTMS.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class BytesNotFoundInParseMessageException extends RuntimeException{

    public BytesNotFoundInParseMessageException(String message){
        super(message);
    }
}
