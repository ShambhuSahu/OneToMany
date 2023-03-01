package com.example.employeeproject.servcie;

import com.example.employeeproject.entity.CartEntity;
import com.example.employeeproject.entity.ItemEntity;
import com.example.employeeproject.mapper.CartMapper;
import com.example.employeeproject.mapper.ItemMapper;
import com.example.employeeproject.model.CartRequest;
import com.example.employeeproject.model.CartResponse;
import com.example.employeeproject.model.ItemRequest;
import com.example.employeeproject.model.ItemResponse;
import com.example.employeeproject.repository.CartRepository;
import com.example.employeeproject.repository.ItemRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class CartService {
    private final CartRepository cartRepository;
    private final ItemRepository itemRepository;
    private final CartMapper cartMapper;
    private final ItemMapper itemMapper;

    public CartService(CartRepository cartRepository, ItemRepository itemRepository, CartMapper cartMapper, ItemMapper itemMapper) {
        this.cartRepository = cartRepository;
        this.itemRepository = itemRepository;

        this.cartMapper = cartMapper;
        this.itemMapper = itemMapper;
    }

    public CartRequest createCart(CartRequest cartRequest) {
        CartEntity cartEntity=cartRepository.save(cartMapper.modelToEntity(cartRequest));
        log.info(cartEntity);
        CartRequest cartRequest1=cartMapper.entityToModel(cartEntity);
        return cartRequest1;

    }

    public List<CartRequest> getAllCart() {

        List<CartEntity> cartEntityList=cartRepository.findAll();
        List<CartRequest> cartRequestList=cartMapper.entityToModel2(cartEntityList);
        return cartRequestList;
    }


    public CartResponse updateCart(Long cartId, CartRequest cartRequest) {
        CartEntity cartEntity = cartRepository.findById(cartId).get();

        cartEntity = cartMapper.modelToEntity(cartRequest);
        cartEntity.setCartId(cartId);
        cartRepository.save(cartEntity);
        log.info(cartEntity.getItems());



//        CartEntity cartEntity1=cartEntity.get();

      //  List<ItemEntity> itemId=cartEntity.getItems();

//        for(ItemEntity itemEntitys:itemId)
//        {
//           Long itemId1=  itemEntitys.getItemId();
//           System.out.println(itemId1);
//
//        }
//

        CartResponse cartResponse = new CartResponse();

        return cartResponse;

    }


    public ItemResponse updateItem1(Long cartId, Long itemId, ItemRequest itemRequest) {

        CartEntity cartEntity=cartRepository.findById(cartId).get();

        ItemEntity itemToUpdate=cartEntity.getItems().stream().
                filter(i->i.getItemId().equals(itemId)).findFirst().get();

        itemToUpdate.setItem1(itemRequest.getItem1());
        itemToUpdate.setItem2(itemRequest.getItem2());
        itemToUpdate.setQuantity(itemRequest.getQuantity());
        itemToUpdate.setPrice(itemRequest.getPrice());

        cartRepository.save(cartEntity);

        ItemResponse itemResponse=new ItemResponse();
        itemResponse.setItemId(itemToUpdate.getItemId());
        return itemResponse;


    }
}
