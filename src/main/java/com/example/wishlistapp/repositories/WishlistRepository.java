package com.example.wishlistapp.repositories;

import com.example.wishlistapp.models.Item;
import com.example.wishlistapp.models.Wishlist;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class WishlistRepository implements IWishlistRepository {

    @Value("${spring.datasource.url}")
    String url;
    @Value("${spring.datasource.username}")
    String username;
    @Value("${spring.datasource.password}")
    String pwd;

    public List<Wishlist> getWishlistByUserID(int id) {

        List<Wishlist> wishlists = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(url, username, pwd)) {

            String SQL = "SELECT * FROM wishlist WHERE user_id = ?";
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int wishlist_id = rs.getInt(1);
                String wishlist_title = rs.getString(2);
                wishlists.add(new Wishlist(wishlist_id, wishlist_title));
            }

        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return wishlists;
    }
}
