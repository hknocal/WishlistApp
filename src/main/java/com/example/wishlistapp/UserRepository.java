package com.example.wishlistapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    @Value("${spring.datasource.url}")
    String url;
    @Value("${spring.datasource.username}")
    String username;
    @Value("${spring.datasource.password}")
    String pwd;

    public List<User> getUsers() {
        List<User> userList = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(url, username, pwd)){
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
}
