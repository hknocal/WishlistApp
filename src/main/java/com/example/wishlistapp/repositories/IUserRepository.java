package com.example.wishlistapp.repositories;

import com.example.wishlistapp.models.User;

import java.util.List;

public interface IUserRepository {
    List<User> getUsers();
    User getUserByID(int id);
    void createUser(User user);
    void editUser(User user);
    void deleteUser(int id);


}
