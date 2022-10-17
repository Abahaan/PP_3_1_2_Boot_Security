package ru.kata.test_3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kata.test_3.models.User;
import ru.kata.test_3.services.UserService;


import java.security.Principal;

@RestController
@RequestMapping("api/user")
public class UserRestController {
    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<User> getUserById(Principal principal) {
        return new ResponseEntity<>(userService.getUserByUsername(principal.getName()), HttpStatus.OK);
    }
}