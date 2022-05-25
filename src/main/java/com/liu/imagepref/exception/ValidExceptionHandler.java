package com.liu.imagepref.exception;

import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author: hollow
 * @Date: 2022/5/24 15:24
 */

@RestControllerAdvice
public class ValidExceptionHandler {

    @ExceptionHandler(BindException.class)
    public String validExceptionHandler(BindException exception) {
        return exception.getAllErrors().get(0).getDefaultMessage();
    }

}