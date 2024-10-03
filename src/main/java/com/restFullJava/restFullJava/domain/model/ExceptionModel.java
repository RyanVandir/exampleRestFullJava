package com.restFullJava.restFullJava.domain.model;

import lombok.Data;

@Data
public class ExceptionModel {

    private String message;
    private Integer statusCode;
}
