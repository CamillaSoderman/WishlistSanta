package com.example.WishlistSanta;

import javax.persistence.*;
import java.util.ArrayList;
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Long id;

    private String name;
    private String email;
//    @OneToMany
    private ArrayList<String> wishes = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User(String name, String email, ArrayList<String> wishes) {
        this.name = name;
        this.email = email;
        this.wishes = wishes;
    }

    public User() {
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

    public void addWish(String wish) {
        this.wishes.add(wish);
    }
}
