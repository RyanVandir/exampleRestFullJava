package com.restFullJava.restFullJava.domain.exception.handler;

import com.restFullJava.restFullJava.domain.model.ExceptionModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExampleHandlerException {
    @ExceptionHandler(InvalidRequestException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionModel invalidRequestException(InvalidRequestException ex) {
        System.out.println(ex.getMessage());
        ExceptionModel exceptionModel = new ExceptionModel();
        exceptionModel.setMessage("Dados inválidos");
        exceptionModel.setStatusCode(HttpStatus.BAD_REQUEST.value());
        return exceptionModel;
    }
}
