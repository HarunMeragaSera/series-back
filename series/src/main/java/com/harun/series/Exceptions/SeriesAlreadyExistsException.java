package com.harun.series.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class SeriesAlreadyExistsException extends RuntimeException{
    public SeriesAlreadyExistsException(String name){
        super("Series with name "+name+" already exists");
    }
}
