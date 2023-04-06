package com.example.wishlistapp;

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

    public void createUser(User user) {
        repository.createUser(user);
    }
}
