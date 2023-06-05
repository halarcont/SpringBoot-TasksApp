package com.heriberto.springboot.tareas_app.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ToDoExceptions extends RuntimeException{
    private String message;
    private HttpStatus httpStatus;

    public ToDoExceptions(String message, HttpStatus HttpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
