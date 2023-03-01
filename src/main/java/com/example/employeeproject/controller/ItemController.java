package com.example.employeeproject.controller;

import com.example.employeeproject.entity.ItemEntity;
import com.example.employeeproject.model.ItemRequest;
import com.example.employeeproject.model.ItemResponse;
import com.example.employeeproject.servcie.ItemService;
import org.springframework.boot.autoconfigure.graphql.ConditionalOnGraphQlSchema;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PutMapping("/items/{itemId}")
    public ResponseEntity<ItemResponse> updateItem(@PathVariable Long itemId, @RequestBody ItemRequest itemRequest)
    {
        ItemResponse itemResponse=itemService.updateItem(itemId,itemRequest);
        return new ResponseEntity<>(itemResponse,HttpStatus.OK);
    }

    @GetMapping("/items")
    public ResponseEntity<List<ItemRequest>> getAllItems()
    {
        List<ItemRequest> itemRequestList=itemService.getAllItems();
        return new ResponseEntity<>(itemRequestList, HttpStatus.OK);
    }

    @PostMapping("/items")
    public ResponseEntity<ItemResponse> createItem(@RequestBody ItemRequest itemRequest)
    {
        ItemResponse itemResponse=itemService.createItem(itemRequest);
        return new ResponseEntity<>(itemResponse,HttpStatus.OK);
    }

}
