package com.example.wishlistapp.repositories;

import com.example.wishlistapp.models.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository {
    @Value("${spring.datasource.url}")
    String url;
    @Value("${spring.datasource.username}")
    String username;
    @Value("${spring.datasource.password}")
    String pwd;

    public List<User> getUsers() {
        List<User> userList = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(url, username, pwd)) {
            String SQL = "SELECT * FROM user";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                int id = rs.getInt(1);
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String email = rs.getString("email");
                userList.add(new User(id, first_name, last_name, email));
            }

            return userList;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public User getUserByID(int id) {
        try (Connection con = DriverManager.getConnection(url, username, pwd)) {
            String SQL = "SELECT * FROM user WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String first_name = rs.getString(2);
                String last_name = rs.getString(3);
                String email = rs.getString(4);
                return new User(id, first_name, last_name, email);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return null;
    }

    public User getUserByEmail(String email) {
        try (Connection con = DriverManager.getConnection(url, username, pwd)) {
            String SQL = "SELECT * FROM user WHERE email = ?";
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt(1);
                String first_name = rs.getString(2);
                String last_name = rs.getString(3);
                return new User(id, first_name, last_name, email);
            }

        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return null;
    }

    public void createUser(User user) {
        try (Connection con = DriverManager.getConnection(url, username, pwd)) {
            String SQL = "INSERT INTO user (first_name, last_name, email) VALUES(?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setString(1, user.getFirst_name());
            pstmt.setString(2, user.getLast_name());
            pstmt.setString(3, user.getEmail());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public void editUser(User user) {
        try (Connection con = DriverManager.getConnection(url, username, pwd)) {
            String SQL = "UPDATE user SET first_name = ?, last_name = ?, email = ? WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(SQL);

            pstmt.setString(1, user.getFirst_name());
            pstmt.setString(2, user.getLast_name());
            pstmt.setString(3, user.getEmail());
            pstmt.setInt(4, user.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public void deleteUser(int id) {
        try (Connection con = DriverManager.getConnection(url, username, pwd)) {
            String SQL = "DELETE FROM item WHERE wishlist_id IN (SELECT id FROM wishlist WHERE user_id = ?)";
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

            SQL = "DELETE FROM wishlist WHERE user_id = ?";
            pstmt = con.prepareStatement(SQL);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

            SQL = "DELETE FROM user WHERE id = ?";
            pstmt = con.prepareStatement(SQL);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}