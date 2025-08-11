package com.service;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class InventoryServiceImpl implements InventoryService {

    private Set<String> availableItems;

    public InventoryServiceImpl() {
      
        availableItems = new HashSet<>();
        availableItems.add("ITEM001");
        availableItems.add("ITEM002");
        availableItems.add("ITEM003");
    }

    @Override
    public boolean isAvailable(String itemId) {
        return availableItems.contains(itemId);
    }
}
