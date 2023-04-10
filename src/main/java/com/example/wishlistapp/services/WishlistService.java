package com.example.wishlistapp.services;

import com.example.wishlistapp.models.Wishlist;
import com.example.wishlistapp.repositories.WishlistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {
    private final WishlistRepository repository;

    public WishlistService(WishlistRepository repository) {
        this.repository = repository;
    }

    public List<Wishlist> getWishlistByUserID(int id) {
        return repository.getWishlistByUserID(id);
    }
}
