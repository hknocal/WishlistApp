package com.example.wishlistapp.services;

import com.example.wishlistapp.models.Item;
import com.example.wishlistapp.repositories.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemService {
    private final ItemRepository repository;

    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    public List<Item> getItemsByWishlistID(int id) {
        return repository.getItemsByWishlistID(id);
    }

    public Item getItemsByID(int id) {
        return repository.getItemById(id);
    }

    public void addItem(Item item) {
        repository.addItem(item);
    }

    public void editItem(Item item) {
        repository.editItem(item);
    }

    public void deleteItem(int id) {
        repository.deleteItem(id);
    }
}
