package com.restFullJava.restFullJava.domain.port;

import com.restFullJava.restFullJava.adapter.in.request.ExampleRequest;
import com.restFullJava.restFullJava.domain.model.ExampleModel;
import org.springframework.web.bind.annotation.RequestBody;

public interface ExampleCorePort {
    ExampleRequest createdExample(ExampleModel exampleModel);
}
