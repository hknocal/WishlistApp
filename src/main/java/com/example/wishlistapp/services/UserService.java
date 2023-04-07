package com.example.wishlistapp.services;

import com.example.wishlistapp.models.User;
import com.example.wishlistapp.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository userRepository) {
        this.repository = userRepository;
    }

    public List<User> getUsers() {
        return repository.getUsers();
    }

    public User getUserByID(int id) {
        return repository.getUserByID(id);
    }

    public void createUser(User user) {
        repository.createUser(user);
    }

    public void editUser(User user) {
        repository.editUser(user);
    }

    public void deleteUser(int id) {
        repository.deleteUser(id);
    }
}
