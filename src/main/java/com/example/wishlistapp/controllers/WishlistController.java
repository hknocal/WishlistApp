package com.example.wishlistapp.controllers;

import com.example.wishlistapp.models.Item;
import com.example.wishlistapp.models.Wishlist;
import com.example.wishlistapp.services.WishlistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/add-wishlist")
    public String addWishlist (@RequestParam("id") int id, Model model) {
        model.addAttribute("wishlist", new Wishlist());
        model.addAttribute("user_id", id);
        return "add-wishlist";
    }

    @PostMapping("/add-wishlist")
    public String saveWishlist(@ModelAttribute Wishlist wishlist, @RequestParam("id") int id, Model model) {
        wishlist.setId(id);
        wishlistService.addWishlist(wishlist);
        model.addAttribute("wishlist", wishlist);
        return "add-wishlist-success";
    }

}
