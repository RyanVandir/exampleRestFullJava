package com.restFullJava.restFullJava.adapter.in.controller;

import com.restFullJava.restFullJava.adapter.in.request.ExampleRequest;
import com.restFullJava.restFullJava.domain.mapper.ExampleMapper;
import com.restFullJava.restFullJava.domain.port.ExampleCorePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<ExampleRequest> findAll() {
        return exampleCorePort.findAll();
    }

    @GetMapping("{id}")
    public ExampleRequest findById(@PathVariable String id) {
        return exampleCorePort.findById(id);
    }
    @PutMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ExampleRequest updateExample(@RequestBody ExampleRequest exampleRequest) {
        return exampleCorePort.updateExample(exampleMapper.toModel(exampleRequest));
    }
}
