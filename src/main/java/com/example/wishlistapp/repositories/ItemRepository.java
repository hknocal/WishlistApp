package com.example.wishlistapp.repositories;

import com.example.wishlistapp.models.Item;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class ItemRepository implements IItemRepository {

    @Value("${spring.datasource.url}")
    String url;
    @Value("${spring.datasource.username}")
    String username;
    @Value("${spring.datasource.password}")
    String pwd;

    public List<Item> getItemsByWishlistID(int id) {
        List<Item> items = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(url, username, pwd)) {

            String SQL = "SELECT * FROM item WHERE wishlist_id = ?";
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int item_id = rs.getInt(1);
                String item_name = rs.getString(2);
                String item_link = rs.getString(3);
                int item_price = rs.getInt(4);
                int item_quantity = rs.getInt(5);
                items.add(new Item(item_id, item_name, item_link, item_price, item_quantity));
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }

        return items;
    }

    public void addItem(Item item) {
        try (Connection con = DriverManager.getConnection(url, username, pwd)) {

            String SQL = "INSERT INTO item (item_name, item_link, item_price, item_quantity, wishlist_id) VALUES (?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setString(1, item.getItem_name());
            pstmt.setString(2, item.getItem_link());
            pstmt.setInt(3, item.getItem_price());
            pstmt.setInt(4, item.getItem_quantity());
            pstmt.setInt(5, item.getId());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
