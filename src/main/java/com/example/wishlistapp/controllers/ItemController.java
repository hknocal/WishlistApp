package com.example.wishlistapp.controllers;

import com.example.wishlistapp.models.Item;
import com.example.wishlistapp.services.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Controller
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/wishlist/items")
    public String getItemsByWishlistID (@RequestParam("id") int id, Model model) {
        List<Item> items = itemService.getItemsByWishlistID(id);
        model.addAttribute("item", items);
        return "items";
    }
}
