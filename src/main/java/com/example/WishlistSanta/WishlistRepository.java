package com.example.WishlistSanta;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class WishlistRepository {
    ArrayList<Wishlist> lists;


    public WishlistRepository() {
        lists = new ArrayList<>();
        lists = wishGenerator();
        for (Wishlist wish : lists) {
            System.out.println("\nNamn: " + wish.getName() + "\nE-post: " + wish.getEmail() + "\nWishes: " + wish.getWishes());
        }
    }

    public ArrayList<Wishlist> getlists() {
        return lists;
    }

    public void addList(Wishlist wishlist) {
        lists.add(wishlist);
    }

    public ArrayList<Wishlist> wishGenerator() {

        //Arrays of names and possible wishes
        String[] names = new String[]{"Nils", "Erik", "Maja", "Max", "Elin"};
        String[] wishesArr = new String[]{"Nintendo Switch", "Pony", "Lego", "Gitarr", "Fotbollsskor", "Cykel", "Radiostyrd bil", "Skateboard",
                "Karaokemaskin", "Minecraft", "Målarbok", "Elsparkcykel", "Målarpennor", "Spider-man", "Frozen", "Pussel"};

        // List of numbers used to generate wishlists
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < wishesArr.length; i++) {
            numbers.add(i);
        }

        // Generate one wishlist per user and store in object
        for (int i = 0; i < names.length; i++) {
            ArrayList<String> wishes = new ArrayList<>();     // List to store wishes
            Collections.shuffle(numbers);                           // Shuffle numbers to pick random wishes for each user
            for (int j = 0; j < 5; j++) {
                wishes.add(wishesArr[numbers.get(j)]);              // Get wish at (random) number and add to list
            }
            lists.add(new Wishlist(names[i], names[i].toLowerCase() + "@epost.se", wishes));    // Create object and add to lists array
        }

        return lists;
    }
    public Wishlist getWishList(String email) {
        for (Wishlist book : lists) {
            if (Objects.equals(book.getEmail(), email)) {
                return book;
            }
        }
        return null;
    }

}
