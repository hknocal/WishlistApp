package com.example.wishlistapp.controllers;

import com.example.wishlistapp.models.Item;
import com.example.wishlistapp.models.Wishlist;
import com.example.wishlistapp.services.WishlistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class WishlistController {

    private final WishlistService wishlistService;

    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    @GetMapping("/wishlist")
    public String getWishlistsByID (@RequestParam("id") int id, Model model) {
        List<Wishlist> wishlists = wishlistService.getWishlistByUserID(id);
        model.addAttribute("wishlist", wishlists);
        return "wishlist";
    }

}
