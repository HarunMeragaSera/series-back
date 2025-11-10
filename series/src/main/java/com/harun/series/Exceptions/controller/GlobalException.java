package com.harun.series.Exceptions.controller;

import com.harun.series.Exceptions.DTO.messageDTO;
import com.harun.series.Exceptions.SeriesAlreadyExistsException;
import com.harun.series.Exceptions.SeriesNotFoundException;
import com.harun.series.Helpers.Operations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(SeriesAlreadyExistsException.class)
    public ResponseEntity<messageDTO> throwsConflictException(SeriesAlreadyExistsException e){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new messageDTO(HttpStatus.CONFLICT,e.getMessage()));
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<messageDTO> validationException(MethodArgumentNotValidException e){
        List<String> messages = new ArrayList<>();
        e.getBindingResult().getAllErrors().forEach((err)->{
            messages.add(err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(new messageDTO(HttpStatus.BAD_REQUEST, Operations.trimBrackets(messages.toString())));
    }
    @ExceptionHandler(SeriesNotFoundException.class)
    public ResponseEntity<messageDTO> seriesNotFoundException(SeriesNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body( new messageDTO(HttpStatus.CONFLICT,ex.getMessage()));
    }

}
