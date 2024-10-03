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
import java.util.Objects;

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

    @Override
    public ExampleRequest findById(String id) {
        ExampleModel exampleModel = new ExampleModel();
        exampleModels.forEach(it -> {
            if (Objects.equals(it.getId(), id)) {
                exampleModel.setId(it.getId());
                exampleModel.setMessage(it.getMessage());
            }
        });
        if (exampleModel.getId() != null) {
            return exampleMapper.toRequest(exampleModel);
        } else {
            throw new NoContentFoundException("Id não encontrado");
        }
    }

    @Override
    public ExampleRequest updateExample(ExampleModel exampleModel) {
        ExampleModel exampleModelResponse = new ExampleModel();
        if (exampleModel.getMessage().isBlank()) {
            throw new InvalidRequestException("deu ruim nesse bagulho");

        } else {
            exampleModels.forEach(it -> {
                if (Objects.equals(it.getId(), exampleModel.getId())) {
                    it.setMessage(exampleModel.getMessage());
                    exampleModelResponse.setId(it.getId());
                    exampleModelResponse.setMessage(it.getMessage());
                }
            });
            if (exampleModelResponse.getId() == null) {
                throw new NoContentFoundException("Id não encontrado");
            }
            return exampleMapper.toRequest(exampleModelResponse);
        }
    }
}