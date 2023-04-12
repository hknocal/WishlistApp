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

    public Wishlist getWishlistById(int id) {
        return repository.getWishlistById(id);
    }

    public void addWishlist(Wishlist wishlist) {
        repository.addWishlist(wishlist);
    }

    public void editWishlist(Wishlist wishlist) {
        repository.editWishlist(wishlist);
    }
    public void deleteWishlist(int id) {
        repository.deleteWishlist(id);
    }
}
