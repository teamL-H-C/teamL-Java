package com.example.beer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    @GetMapping
    public String showDashboard() {
        // ログイン済みユーザーのロールに応じた出し分けは Thymeleaf 側で行う
        return "dashboard/dashboard";  // templates/dashboard/dashboard.html を表示
    }
}