package com.example.wishlistapp.models;

public class Wishlist {
    private int wishlist_id;
    private String wishlist_title;
    private int user_id;

    public Wishlist(int wishlist_id, String wishlist_title, int user_id) {
        this.wishlist_id = wishlist_id;
        this.wishlist_title = wishlist_title;
        this.user_id = user_id;
    }

    public Wishlist() {
    }

    public int getWishlist_id() {
        return wishlist_id;
    }

    public void setWishlist_id(int wishlist_id) {
        this.wishlist_id = wishlist_id;
    }

    public String getWishlist_title() {
        return wishlist_title;
    }

    public void setWishlist_title(String wishlist_title) {
        this.wishlist_title = wishlist_title;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Wishlist{" +
                "wishlist_id=" + wishlist_id +
                ", wishlist_title='" + wishlist_title + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}



