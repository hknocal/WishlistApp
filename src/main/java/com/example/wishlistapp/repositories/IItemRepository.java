package com.example.wishlistapp.repositories;

import com.example.wishlistapp.models.Item;

import java.util.List;

public interface IItemRepository {
    List<Item> getItemsByWishlistID(int id);
    void addItem(Item item);
    void editItem(Item item);
    void deleteItem(int id);
}
