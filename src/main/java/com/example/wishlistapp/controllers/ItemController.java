package com.example.wishlistapp.controllers;

import com.example.wishlistapp.models.Item;
import com.example.wishlistapp.services.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/wishlist/items")
    public String getItemsByWishlistID(@RequestParam("id") int id, Model model) {
        List<Item> items = itemService.getItemsByWishlistID(id);
        model.addAttribute("item", items);
        model.addAttribute("wishlist_id", id);
        return "items";
    }

    @GetMapping("/add-item")
    public String addItem(@RequestParam("id") int id, Model model) {
        model.addAttribute("item", new Item());
        model.addAttribute("wishlist_id", id);
        return "add-item";
    }

    @PostMapping("/add-item")
    public String saveItem(@ModelAttribute Item item, @RequestParam("id") int id, Model model) {
        model.addAttribute("item", item);
        item.setWishlist_id(id);
        itemService.addItem(item);
        return "add-item-success";
    }

    @GetMapping("/edit-item")
    public String editItem(@RequestParam("id") int id, Model model) {
        Item item = itemService.getItemsByID(id);
        model.addAttribute("item", item);
        return "edit-item";
    }

    @PostMapping("/edit-item")
    public String saveItemEdit(@ModelAttribute Item item, Model model) {
        model.addAttribute("item", item);
        itemService.editItem(item);
        return "edit-item-success";
    }
    @GetMapping("/delete-item")
    public String deleteItem(@RequestParam("id") int id, @RequestParam("wishlist_id") int wishlist_id) {
        itemService.deleteItem(id);
        return "redirect:/wishlist/items?id=" + wishlist_id;
    }
}
