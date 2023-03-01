package com.example.employeeproject.servcie;

import com.example.employeeproject.entity.ItemEntity;
import com.example.employeeproject.mapper.ItemMapper;
import com.example.employeeproject.model.ItemRequest;
import com.example.employeeproject.model.ItemResponse;
import com.example.employeeproject.repository.ItemRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2

public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    public ItemService(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    public List<ItemRequest> getAllItems() {

        List<ItemEntity> itemEntityList=itemRepository.findAll();

       List<ItemRequest> itemRequestList=itemMapper.entityToModel(itemEntityList);
       return itemRequestList;
    }

    public ItemResponse updateItem(Long itemId, ItemRequest itemRequest) {

        ItemEntity itemEntity=itemRepository.findById(itemId).get();
        log.info(itemEntity);

        itemEntity=itemMapper.modelToEntity(itemRequest);
        itemEntity.setItemId(itemId);

        ItemResponse itemResponse=new ItemResponse();
        itemResponse.setItemId(itemEntity.getItemId());
        return itemResponse;

    }

    public ItemResponse createItem(ItemRequest itemRequest) {

        ItemEntity itemEntity=itemMapper.modelToEntity(itemRequest);
        itemRepository.save(itemEntity);
        ItemResponse itemResponse=new ItemResponse();
        itemResponse.setItemId(itemEntity.getItemId());
        return itemResponse;
    }
}
