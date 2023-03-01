package com.example.employeeproject.mapper;


import com.example.employeeproject.entity.CartEntity;
import com.example.employeeproject.model.CartRequest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CartMapper {

    CartRequest entityToModel(CartEntity cartEntity);
    CartEntity modelToEntity(CartRequest cartRequest);

    List<CartRequest> entityToModel2(List<CartEntity> cartEntityList);
}
