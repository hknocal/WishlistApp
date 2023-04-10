package com.example.wishlistapp.models;

public class Wishlist {
    private int id;
    private String wishlist_title;

    public Wishlist(int id, String wishlist_title) {
        this.id = id;
        this.wishlist_title = wishlist_title;
    }

    public Wishlist() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWishlist_title() {
        return wishlist_title;
    }

    public void setWishlist_title(String wishlist_title) {
        this.wishlist_title = wishlist_title;
    }

    @Override
    public String toString() {
        return "Wishlist{" +
                "id=" + id +
                ", wishlist_title='" + wishlist_title + '\'' +
                '}';
    }
}