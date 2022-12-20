package com.example.WishlistSanta;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class WishlistRepository {
    ArrayList<Wishlist> lists;


    public WishlistRepository() {

    }
    public ArrayList<Wishlist> getlists() {
        return lists;
    }
    public void addList(Wishlist wishlist){
        lists.add(wishlist);
    }
}
