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
    String wishlistPost(Model model, @ModelAttribute Wishlist wishlist) {
        model.addAttribute("wishlist", wishlist);
        System.out.println(wishlist.getName());
        return "wishlist01";
    }

}
