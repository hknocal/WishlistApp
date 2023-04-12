package com.example.wishlistapp.models;

public class Wishlist {
    private int id;
    private String wishlist_title;
    private int user_id;

    public Wishlist(int id, String wishlist_title, int user_id) {
        this.id = id;
        this.wishlist_title = wishlist_title;
        this.user_id = user_id;
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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Wishlist{" +
                "id=" + id +
                ", wishlist_title='" + wishlist_title + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}