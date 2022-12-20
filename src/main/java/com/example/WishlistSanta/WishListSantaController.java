package com.example.WishlistSanta;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class WishListSantaController {

    @Autowired
    Wishlist wishlist;

    @GetMapping("/")
    String wishlist() {
        return "wishlist01";
    }

    @PostMapping("/")
    String wishlistPost(Model model, @RequestParam String name, @RequestParam String email, @RequestParam(required = false, defaultValue = "")ArrayList<String> wishes) {
        Wishlist wishlist = new Wishlist(name, email, wishes);
        System.out.println(wishlist.getWishes() + wishlist.getEmail() + wishlist.getName());
        model.addAttribute("wish", wishlist);
        return "wishlist01";
    }



}
