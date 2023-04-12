package com.example.wishlistapp.repositories;

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
                int user_id = rs.getInt(3);
                wishlists.add(new Wishlist(wishlist_id, wishlist_title, user_id));
            }

        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return wishlists;
    }

    public Wishlist getWishlistById(int id) {
        try (Connection con = DriverManager.getConnection(url, username, pwd)) {
            String SQL = "SELECT * FROM wishlist WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if(rs.next()) {
                int wishlist_id = rs.getInt(1);
                String wishlist_title = rs.getString(2);
                int user_id = rs.getInt(3);
                return new Wishlist(wishlist_id, wishlist_title, user_id);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return null;
    }

    public void addWishlist(Wishlist wishlist) {
        try (Connection con = DriverManager.getConnection(url, username, pwd)) {

            String SQL = "INSERT INTO wishlist (wishlist_title, user_id) VALUES (?,?)";
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setString(1, wishlist.getWishlist_title());
            pstmt.setInt(2, wishlist.getId());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public void editWishlist(Wishlist wishlist) {
        try (Connection con = DriverManager.getConnection(url, username, pwd)) {
            String SQL = "UPDATE wishlist SET wishlist_title = ? WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(SQL);

            pstmt.setString(1, wishlist.getWishlist_title());
            pstmt.setInt(2, wishlist.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }

    }

    public void deleteWishlist(int id) {
        try (Connection con = DriverManager.getConnection(url, username, pwd)) {
            String SQL = "DELETE FROM item WHERE wishlist_id = ?";
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

            SQL = "DELETE FROM wishlist WHERE id = ?";
            pstmt = con.prepareStatement(SQL);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
