package com.example.WishlistSanta;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Wishlist {

    private String name;
    private String email;
    private ArrayList<String> wishes;

    public Wishlist(String name, String email, ArrayList<String> wishes) {
        this.name = name;
        this.email = email;
        this.wishes = wishes;
    }

    public Wishlist() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<String> getWishes() {
        return wishes;
    }

    public void setWishes(ArrayList<String> wishes) {
        this.wishes = wishes;
    }
}
