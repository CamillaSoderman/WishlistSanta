package com.example.WishlistSanta;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class WishListSantaController {

    @Autowired
    private WishlistRepository repository;
    @Autowired
    WishRepository wishRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    String wishlist(HttpSession session, Model model) {
        if (session.getAttribute("wishlist") == null) {
           User user = userRepository.save(new User());
            session.setAttribute("wishlist",  user);
        }
        model.addAttribute("wishlist", session.getAttribute("wishlist"));
            return "wishlist01";

    }

    @PostMapping("/")
    String wishlistPost(HttpSession session, Model model, @ModelAttribute User wishlist) {
        User sessionWishlist = (User) session.getAttribute("wishlist");
        sessionWishlist.setName(wishlist.getName());
        sessionWishlist.setEmail(wishlist.getEmail());
        model.addAttribute("wishlist", session.getAttribute("wishlist"));
        return "wishlist02";
    }
    @GetMapping("/add")
    String list(HttpSession session, Model model,@ModelAttribute User wishlist){
        User sessionWishlist = (User) session.getAttribute("wishlist");
        sessionWishlist.setName(wishlist.getName());
        sessionWishlist.setEmail(wishlist.getEmail());
        model.addAttribute("wishlist", session.getAttribute("wishlist"));
        return "wishlist02";
    }
    @PostMapping("/add")
    String addWish(HttpSession session, Model model, @RequestParam(required = false) String wish) {
        Wishes wishes = new Wishes();
        wishes.setWish(wish);
        User user = (User) session.getAttribute("wishlist");
        user.setName(user.getName());
        user.setEmail(user.getEmail());
        model.addAttribute("wishlist", session.getAttribute("wishlist"));
        wishes.setUser(user);
        user.addWish(wishes);
        return "wishlist02";
    }

    @GetMapping("/done")
    String done(HttpSession session, Model model) {
        User wishlist = (User) session.getAttribute("wishlist");
        wishlist.setName(wishlist.getName());
        wishlist.setEmail(wishlist.getEmail());
        model.addAttribute("wishlist", session.getAttribute("wishlist"));
        return "done";
    }
    @GetMapping("/sent")
    String sent(HttpSession session, Model model) {
        model.addAttribute("wishlist", session.getAttribute("wishlist"));
        for (User u : repository.getlists()) {
            userRepository.save(u);
        }
        userRepository.save((User) model.getAttribute("wishlist"));
        return "sent";
    }

    @PostMapping("/clear")
    String clearSession(HttpSession session, Model model) {
        session.setAttribute("wishlist", new User());
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
        User wishlist = repository.getWishList(email);
        model.addAttribute("wishlist", wishlist);
        return "childlist";
    }

}
