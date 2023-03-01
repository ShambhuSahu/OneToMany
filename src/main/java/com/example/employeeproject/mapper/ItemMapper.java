package com.example.employeeproject.mapper;


import com.example.employeeproject.entity.ItemEntity;
import com.example.employeeproject.model.ItemRequest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    ItemRequest entityToModel(ItemEntity itemEntity);
    ItemEntity modelToEntity(ItemRequest itemRequest);

    List<ItemRequest> entityToModel(List<ItemEntity> itemEntityList);
    List<ItemEntity>  modelToEntity2(List<ItemRequest> itemRequestList);
}
