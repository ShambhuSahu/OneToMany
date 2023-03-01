package com.example.employeeproject.controller;


import com.example.employeeproject.model.ItemRequest;
import com.example.employeeproject.model.ItemResponse;
import com.example.employeeproject.servcie.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemUpdateController {
    private final CartService cartService;

    public ItemUpdateController(CartService cartService) {
        this.cartService = cartService;
    }

    @PutMapping("/{cartId}/items/{itemId}")
    public ResponseEntity<ItemResponse> updateItem1(@PathVariable Long cartId, @PathVariable Long itemId, @RequestBody ItemRequest itemRequest) {

        ItemResponse itemResponse= cartService.updateItem1(cartId, itemId, itemRequest);
        return new ResponseEntity<>(itemResponse, HttpStatus.OK);
    }
}
