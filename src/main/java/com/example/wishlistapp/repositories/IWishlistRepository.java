package com.example.wishlistapp.repositories;

import com.example.wishlistapp.models.Item;
import com.example.wishlistapp.models.Wishlist;

import java.util.List;

public interface IWishlistRepository {
    List<Wishlist> getWishlistByUserID(int id);
}
