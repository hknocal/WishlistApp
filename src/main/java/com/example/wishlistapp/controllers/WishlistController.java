        package com.example.wishlistapp.controllers;

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
                List<Wishlist> wishlist = wishlistService.getWishlistByUserID(id);
                model.addAttribute("wishlist", wishlist);
                model.addAttribute("user_id", id);
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
                model.addAttribute("user_id", id); // Add the user_id to the model
                return "add-wishlist-success";
            }

            @GetMapping("/edit-wishlist")
            public String editWishlist(@RequestParam("id") int id, Model model) {
                Wishlist wishlist = wishlistService.getWishlistById(id);
                model.addAttribute("wishlist", wishlist);
                return "edit-wishlist";
            }

            @PostMapping("/edit-wishlist")
            public String saveEditWishlist(@ModelAttribute Wishlist wishlist, Model model) {
                model.addAttribute("wishlist", wishlist);
                wishlistService.editWishlist(wishlist);
                return "edit-wishlist-success";
            }

            @GetMapping("/delete-wishlist")
            public String deleteWishlist(@RequestParam("id") int id, @RequestParam("user_id") int user_id) {
                wishlistService.deleteWishlist(id);
                return "redirect:/wishlist?id=" + user_id;
            }

        }
