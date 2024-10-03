package com.restFullJava.restFullJava.adapter.in.controller;

import com.restFullJava.restFullJava.adapter.in.request.ExampleRequest;
import com.restFullJava.restFullJava.domain.mapper.ExampleMapper;
import com.restFullJava.restFullJava.domain.port.ExampleCorePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("example")
@RequiredArgsConstructor
public class ExampleController {
    private final ExampleCorePort exampleCorePort;
    private final ExampleMapper exampleMapper;

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public ExampleRequest createdExample(@RequestBody ExampleRequest exampleRequest) {

        return exampleCorePort.createdExample(exampleMapper.toModel(exampleRequest));
    }
}
