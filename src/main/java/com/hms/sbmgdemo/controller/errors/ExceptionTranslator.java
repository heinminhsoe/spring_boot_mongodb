package com.hms.sbmgdemo.controller.errors;

import com.hms.sbmgdemo.exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionTranslator {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<String> handleNotFound(EntityNotFoundException ex) {
        String message = (ex != null) ? ex.getMessage() : "";
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

}
