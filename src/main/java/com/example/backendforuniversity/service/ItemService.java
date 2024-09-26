package com.example.backendforuniversity.service;

import com.example.backendforuniversity.models.Item;
import com.example.backendforuniversity.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item findById(long id) {
        return itemRepository.getOne(id);
    }
    public List<Item> findAll() {
        return itemRepository.findAll();
    }
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
