package ru.kata.test_3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.test_3.models.User;
import ru.kata.test_3.services.RoleService;
import ru.kata.test_3.services.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }
    @GetMapping
    public String showMainAdminPage (@AuthenticationPrincipal User principal, Model model){
        model.addAttribute("principal",principal);
        model.addAttribute("userList", userService.getAllUsers());
        model.addAttribute("roleUser", roleService.getRoleByName("ROLE_USER"));
        model.addAttribute("roleAdmin", roleService.getRoleByName("ROLE_ADMIN"));
        model.addAttribute("newUser", new User());
        return "main";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("newUser") User user) {
        userService.addUser(user);
        return "redirect:/admin";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUserById(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/admin";
    }


}
