package com.restFullJava.restFullJava.domain.mapper;

import com.restFullJava.restFullJava.adapter.in.request.ExampleRequest;
import com.restFullJava.restFullJava.domain.model.ExampleModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ExampleMapper {

    ExampleRequest toResquest(ExampleModel exampleModel);

    ExampleModel toModel(ExampleRequest exampleRequest);
}
