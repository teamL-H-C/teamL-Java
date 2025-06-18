package com.example.beer.controller;

import com.example.beer.model.User;
import com.example.beer.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // ユーザー一覧
    @GetMapping
    public String list(Model model) {
        model.addAttribute("userList", userService.findAll());
        return "users/list";
    }

    // 新規登録フォーム
    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("user", new User());
        return "users/form";
    }

    // 登録処理
    @PostMapping("/new")
    public String create(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/users";
    }

    // 編集フォーム
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        Optional<User> user = userService.findById(id);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
            return "users/form"; // または edit.html
        }
        return "redirect:/users";
    }

    // 編集保存処理
    @PostMapping("/{id}/edit")
    public String update(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/users";
    }
}
