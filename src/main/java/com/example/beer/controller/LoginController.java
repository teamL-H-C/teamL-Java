package com.example.beer.controller;

import com.example.beer.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/")
    public String LoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {
        if (loginService.authenticate(username, password)) {
            return "dashboard"; // ログイン成功
        } else {
            model.addAttribute("error", "ユーザー名またはパスワードが間違っています");
            return "login"; // ログイン失敗
        }
    }
}

