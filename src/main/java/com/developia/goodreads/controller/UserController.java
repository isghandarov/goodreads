package com.developia.goodreads.controller;

import com.developia.goodreads.dao.entity.UsersEntity;
import com.developia.goodreads.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String register(Model model) {
        model.addAttribute("user", new UsersEntity());
        return "registration";
    }

    @PostMapping("/registration")
    public String register(@ModelAttribute("user") UsersEntity user) {

        userService.register(user);
        return "redirect:/users/login";
    }
}
