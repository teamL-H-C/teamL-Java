package com.example.beer.service;

import com.example.beer.model.AnalyticsResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AnalyticsService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String apiUrl = "https://teaml-python-predict-api.azurewebsites.net/api/weekly";

    public AnalyticsResponse fetchWeeklyPredictions() {
        return restTemplate.getForObject(apiUrl, AnalyticsResponse.class);
    }
}
