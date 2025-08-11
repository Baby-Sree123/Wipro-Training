package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private CartValidator cartValidator;

   
    private List<String> getCartItems(String cartId) {
        if ("CART001".equals(cartId)) {
            return Arrays.asList("ITEM001", "ITEM002");
        } else if ("CART002".equals(cartId)) {
            return Arrays.asList("ITEM003", "ITEM004"); // ITEM004 unavailable
        }
        return Arrays.asList();
    }

    @Override
    public String checkout(String cartId) {
        if (!cartValidator.validateCart(cartId)) {
            return "Cart is invalid";
        }

        List<String> items = getCartItems(cartId);

        for (String item : items) {
            if (!inventoryService.isAvailable(item)) {
                return "Item out of stock";
            }
        }

     

        return "Checkout successful for " + cartId;
    }
}
