package com.restFullJava.restFullJava.domain.port;

import com.restFullJava.restFullJava.adapter.in.request.ExampleRequest;
import com.restFullJava.restFullJava.domain.model.ExampleModel;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ExampleCorePort {
    ExampleRequest createdExample(ExampleModel exampleModel);

    List<ExampleRequest> findAll();

    ExampleRequest findById(String id);

    ExampleRequest updateExample(ExampleModel exampleModel);
}
