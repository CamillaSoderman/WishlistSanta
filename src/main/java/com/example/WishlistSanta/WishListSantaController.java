package com.example.WishlistSanta;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class WishListSantaController {

    @Autowired
    private WishlistRepository repository;

    @GetMapping("/")
    String wishlist(HttpSession session, Model model) {
        if (session.getAttribute("wishlist") == null) {
            session.setAttribute("wishlist", new Wishlist());
        }
        model.addAttribute("wishlist", session.getAttribute("wishlist"));
            return "wishlist01";

    }

    @PostMapping("/")
    String wishlistPost(HttpSession session, Model model, @ModelAttribute Wishlist wishlist) {
        Wishlist sessionWishlist = (Wishlist) session.getAttribute("wishlist");
        sessionWishlist.setName(wishlist.getName());
        sessionWishlist.setEmail(wishlist.getEmail());
        model.addAttribute("wishlist", session.getAttribute("wishlist"));
        return "wishlist02";
    }
    @GetMapping("/add")
    String list(HttpSession session, Model model,@ModelAttribute Wishlist wishlist){
        Wishlist sessionWishlist = (Wishlist) session.getAttribute("wishlist");
        sessionWishlist.setName(wishlist.getName());
        sessionWishlist.setEmail(wishlist.getEmail());
        model.addAttribute("wishlist", session.getAttribute("wishlist"));
        return "wishlist02";
    }
    @PostMapping("/add")
    String addWish(HttpSession session, Model model, @RequestParam(required = false) String wish) {
        Wishlist wishlist = (Wishlist) session.getAttribute("wishlist");
        wishlist.setName(wishlist.getName());
        wishlist.setEmail(wishlist.getEmail());
        model.addAttribute("wishlist", session.getAttribute("wishlist"));
        wishlist.addWish(wish);
        return "wishlist02";
    }

    @GetMapping("/done")
    String done(HttpSession session, Model model) {
        Wishlist wishlist = (Wishlist) session.getAttribute("wishlist");
        wishlist.setName(wishlist.getName());
        wishlist.setEmail(wishlist.getEmail());
        model.addAttribute("wishlist", session.getAttribute("wishlist"));
        return "done";
    }
    @GetMapping("/sent")
    String sent(HttpSession session, Model model) {
        model.addAttribute("wishlist", session.getAttribute("wishlist"));
        repository.lists.add( (Wishlist) model.getAttribute("wishlist"));
        return "sent";
    }

    @PostMapping("/clear")
    String clearSession(HttpSession session, Model model) {
        session.setAttribute("wishlist", new Wishlist());
        model.addAttribute("wishlist", session.getAttribute("wishlist"));
        return "wishlist01";
    }

    @GetMapping("/santa")
    String santalist(Model model){
        model.addAttribute("santaslist",repository.getlists());
        return "santaslist";
}
    @GetMapping("/santa/{email}")
    String chidlist(Model model,@PathVariable String email){
        Wishlist wishlist = repository.getWishList(email);
        model.addAttribute("wishlist", wishlist);
        return "childlist";
    }
}
