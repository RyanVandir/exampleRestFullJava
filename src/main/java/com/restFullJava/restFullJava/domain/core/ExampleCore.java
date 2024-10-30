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
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExampleCore implements ExampleCorePort {
    private final ExampleMapper exampleMapper;

    HashMap<String, ExampleModel> exampleModels = new HashMap<>();

    @Override
    public ExampleRequest createdExample(ExampleModel exampleModel) {
        if (!exampleModel.getMessage().isBlank()) {
            exampleModels.put(exampleModel.getId(), exampleModel);
        } else {
            throw new InvalidRequestException("Mensagem invalida");
        }
        return exampleMapper.toRequest(exampleModel);
    }

    @Override
    public List<ExampleRequest> findAll() {
        if (!exampleModels.isEmpty()) {
            List<ExampleModel> listExampleModels = new ArrayList<>(exampleModels.values());
            return exampleMapper.toRequest(listExampleModels);
        } else {
            throw new NoContentFoundException("Nenhum dado foi encontrado");
        }
    }

    @Override
    public ExampleRequest findById(String id) {
        ExampleModel exampleModel = exampleModels.get(id);
        if (exampleModel != null) {
            return exampleMapper.toRequest(exampleModel);
        } else {
            throw new NoContentFoundException("Id não encontrado");
        }
    }

    @Override
    public ExampleRequest updateExample(ExampleModel exampleModel) {
        ExampleModel exampleModelResponse = exampleModels.get(exampleModel.getId());
        if (exampleModelResponse == null) {
            throw new NoContentFoundException("Id não encontrado");
        } else {
            exampleModels.put(exampleModel.getId(), exampleModel);
            return exampleMapper.toRequest(exampleModel);
        }
    }

    @Override
    public ExampleRequest deleteExample(String id) {
        ExampleModel exampleModelResponse = exampleModels.get(id);
        if (exampleModelResponse == null) {
            throw new NoContentFoundException("Id não encontrado");
        } else {
            exampleModels.remove(id);
            return exampleMapper.toRequest(exampleModelResponse);
        }
    }
}