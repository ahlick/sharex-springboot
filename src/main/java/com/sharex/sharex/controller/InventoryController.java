package com.sharex.sharex.controller;

import com.sharex.sharex.model.InventoryItem;
import com.sharex.sharex.model.InventoryItemRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InventoryController {
    @Autowired
    private InventoryItemRepository inventoryItemRepository;

    @GetMapping("/inventory")
    public List<InventoryItem> getInventoryItems() {
        return inventoryItemRepository.findAll();
    }

    @PostMapping("/inventory")
    public InventoryItem createInventoryItem(@RequestBody InventoryItem item) {
        return inventoryItemRepository.save(item);
    }

    @PutMapping("/inventory/{id}")
    public InventoryItem updateInventoryItem(@PathVariable Long id, @RequestBody InventoryItem item) {
        InventoryItem existingItem = inventoryItemRepository.findById(id).orElse(null);
        if (existingItem == null) {
            throw new EntityNotFoundException("Inventory item not found");
        }
//        existingItem.setName(item.getName());
//        existingItem.setQuantity(item.getQuantity());
        return inventoryItemRepository.save(existingItem);
    }

    @DeleteMapping("/inventory/{id}")
    public void deleteInventoryItem(@PathVariable Long id) {
        inventoryItemRepository.deleteById(id);
    }
}

