package com.sharex.sharex.services;

import com.sharex.sharex.model.InventoryItem;
import com.sharex.sharex.model.InventoryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {
    @Autowired
    private InventoryItemRepository inventoryItemRepository;

    public InventoryItem createInventoryItem(String name, int quantity) {
        InventoryItem item = new InventoryItem();
//        item.setName(name);
//        item.setQuantity(quantity);
        return inventoryItemRepository.save(item);
    }

}
