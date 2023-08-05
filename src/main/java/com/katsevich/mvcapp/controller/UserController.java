package com.katsevich.mvcapp.controller;

import com.katsevich.mvcapp.entity.User;
import com.katsevich.mvcapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showAllUsers(Model model){
        List<User> users = userService.getAllUsers();
        model.addAttribute("allUsers", users);
        return "/allusers";
    }

    @GetMapping("/add")
    public String addUser(Model model){
        model.addAttribute("user", new User());
        return "/userinfo";
    }

    @PostMapping()
    public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/userinfo";
        }
        userService.addUser(user);
        return "redirect:/";
    }
    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam ("userID") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping("/updateUser")
    public String updateUser(Model model, @RequestParam ("userID") int id) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        userService.addUser(user);
        return "/userinfo";
    }

}
