package com.mabdullaev.lesson.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<?> catchRuntimeException(RuntimeException e){
        return ResponseEntity.badRequest().body(new MarketError(e.getMessage(), Arrays.stream(e.getStackTrace()).map(el -> el.toString()).collect(Collectors.joining("; "))));
    }
}
