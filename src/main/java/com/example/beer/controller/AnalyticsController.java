package com.example.beer.controller;

import com.example.beer.model.AnalyticsResponse;
import com.example.beer.service.AnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/analytics")
public class AnalyticsController {

    @Autowired
    private AnalyticsService analyticsService;

    @GetMapping
    public String redirectToWeekly() {
        return "redirect:/analytics/weekly";
    }

    @GetMapping("/weekly")
    public String showWeekly(Model model) {
        AnalyticsResponse response = analyticsService.fetchWeeklyPredictions();
        model.addAttribute("analytics", response);
        return "analytics/weekly";
    }
}

