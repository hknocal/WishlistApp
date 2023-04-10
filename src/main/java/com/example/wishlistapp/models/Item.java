package com.example.wishlistapp.models;

public class Item {
    private int id;
    private String item_name;
    private String item_link;
    private int item_price;
    private int item_quantity;

    public Item(int id, String item_name, String item_link, int item_price, int item_quantity) {
        this.id = id;
        this.item_name = item_name;
        this.item_link = item_link;
        this.item_price = item_price;
        this.item_quantity = item_quantity;
    }

    public Item() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_link() {
        return item_link;
    }

    public void setItem_link(String item_link) {
        this.item_link = item_link;
    }

    public int getItem_price() {
        return item_price;
    }

    public void setItem_price(int item_price) {
        this.item_price = item_price;
    }

    public int getItem_quantity() {
        return item_quantity;
    }

    public void setItem_quantity(int item_quantity) {
        this.item_quantity = item_quantity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", item_name='" + item_name + '\'' +
                ", item_link='" + item_link + '\'' +
                ", item_price=" + item_price +
                ", item_quantity=" + item_quantity +
                '}';
    }
}
