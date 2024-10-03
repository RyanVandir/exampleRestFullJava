package com.restFullJava.restFullJava.adapter.in.request;

import lombok.Data;
import lombok.ToString;

import java.util.UUID;

@Data
public class ExampleRequest {
    private String id = UUID.randomUUID().toString();
    private String message;
}
