package com.restFullJava.restFullJava.domain.exception.handler;

public class InvalidRequestException extends RuntimeException {
    public InvalidRequestException(String msg) {
        super(msg);
    }
}
