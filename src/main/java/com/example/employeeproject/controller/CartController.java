package com.example.employeeproject.controller;

import com.example.employeeproject.model.CartRequest;
import com.example.employeeproject.model.CartResponse;
import com.example.employeeproject.servcie.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/carts")
    public ResponseEntity<CartRequest> createCart(@RequestBody CartRequest cartRequest)
    {
        CartRequest cartRequest1=cartService.createCart(cartRequest);
        return new ResponseEntity<>(cartRequest1, HttpStatus.CREATED);
    }

    @GetMapping("/carts")
    public ResponseEntity<List<CartRequest>> getAllCart()
    {
        List<CartRequest> cartRequestList=cartService.getAllCart();
        return new ResponseEntity<>(cartRequestList,HttpStatus.OK);
    }

    @PutMapping("/carts/{cartId}")
    public ResponseEntity<CartResponse> updateCart(@PathVariable Long cartId,@RequestBody CartRequest cartRequest)
    {
        CartResponse cartResponse=cartService.updateCart(cartId,cartRequest);
        return new ResponseEntity<>(cartResponse,HttpStatus.OK);
    }
}
