package ru.kata.test_3.services;

import ru.kata.test_3.models.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    User getUserById(Long id);

    void updateUserById(User user);

    void deleteUserById(Long id);

    List<User> getAllUsers();

    User getUserByName(String name);
}
