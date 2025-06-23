package com.example.beer.controller;

import com.example.beer.model.AnalyticsResponse;
import com.example.beer.service.AnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/analytics")
public class AnalyticsController {

    @Autowired
    private AnalyticsService analyticsService;

    @GetMapping
    public String redirectToWeekly() {
        return "redirect:/analytics/weekly";
    }

    @SuppressWarnings("unchecked")
    @GetMapping("/weekly")
    public String showWeekly(Model model) {
        AnalyticsResponse response = analyticsService.fetchWeeklyPredictions();
        model.addAttribute("analytics", response);

        Map<String, Object> shipmentSummary = response.getShipment_summary();
        if (shipmentSummary != null) {
            Object beerObj = shipmentSummary.get("🍻 発注用ビール出荷集計");
            if (beerObj instanceof Map<?, ?> beerMapRaw) {
                Map<String, Object> beerMap = (Map<String, Object>) beerMapRaw;
                model.addAttribute("mondaySummary", beerMap.get("月曜用の出荷集計"));
                model.addAttribute("thursdaySummary", beerMap.get("木曜用の出荷集計"));
            }
        }

        return "analytics/weekly";
    }
}

