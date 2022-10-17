package ru.kata.test_3.services;



import ru.kata.test_3.models.User;

import java.util.List;

public interface UserService {

    boolean addUser(User user);

    User getUserById(Long id);

    boolean updateUser(User user);

    boolean deleteUserById(Long id);

    List<User> getAllUsers();

    User getUserByUsername(String name);
}