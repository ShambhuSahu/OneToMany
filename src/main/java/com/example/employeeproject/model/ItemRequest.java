package com.example.employeeproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemRequest  {

    private String item1;
    private String item2;
    private Integer quantity;
    private double price;

   // private CartRequest cartRequest;

}
