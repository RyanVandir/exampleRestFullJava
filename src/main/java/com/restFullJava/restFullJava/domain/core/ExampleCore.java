package com.restFullJava.restFullJava.domain.core;

import com.restFullJava.restFullJava.adapter.in.request.ExampleRequest;
import com.restFullJava.restFullJava.domain.exception.handler.InvalidRequestException;
import com.restFullJava.restFullJava.domain.exception.handler.NoContentFoundException;
import com.restFullJava.restFullJava.domain.mapper.ExampleMapper;
import com.restFullJava.restFullJava.domain.model.ExampleModel;
import com.restFullJava.restFullJava.domain.port.ExampleCorePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExampleCore implements ExampleCorePort {
    private final ExampleMapper exampleMapper;

    List<ExampleModel> exampleModels = new ArrayList<>();
    @Override
    public ExampleRequest createdExample(ExampleModel exampleModel) {
        if (!exampleModel.getMessage().isBlank()) {
            exampleModels.add(exampleModel);
        } else {
            throw new InvalidRequestException("deu ruim nesse bagulho");
        }
        return exampleMapper.toRequest(exampleModel);
    }

    @Override
    public List<ExampleRequest> findAll() {
        if (!exampleModels.isEmpty()) {
           return exampleMapper.toRequest(exampleModels);
        } else {
            throw new NoContentFoundException("Nenhum dado foi encontrado");
        }
    }
}
