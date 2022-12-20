package com.example.WishlistSanta;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class WishListSantaController {

    @GetMapping("/")
    String wishlist(Model model) {
        model.addAttribute("wishlist", new Wishlist());
        return "wishlist01";
    }

    @PostMapping("/")
    String wishlistPost(Model model, @ModelAttribute Wishlist wishlist, String wish) {
        if (wishlist.getWishes() == null) {
            model.addAttribute("wishes", wishlist.getWishes());
        }
        wishlist.getWishes().add(wish);
        return "wishlist01";
    }

    @GetMapping("/done")
    String done(@ModelAttribute Wishlist wishlist) {
        return "done";
    }

}
