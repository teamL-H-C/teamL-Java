package com.example.beer.controller;

import com.example.beer.model.AnalyticsResponse;
import com.example.beer.service.AnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {

    @Autowired
    private AnalyticsService analyticsService;

    @GetMapping("/weekly")
    public AnalyticsResponse getWeeklyPredictions() {
        return analyticsService.fetchWeeklyPredictions();
    }
}