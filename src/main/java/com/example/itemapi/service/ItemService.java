package com.example.itemapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.itemapi.model.Item;

@Service
public class ItemService {

    private final List<Item> items = new ArrayList<>();
    private Long nextId = 1L;

    public Item addItem(Item item) {
        item.setId(nextId++);
        items.add(item);
        return item;
    }

    public Item getItemById(Long id) {
        return items.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
