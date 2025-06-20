// AnalyticsPredictionDetail.java（1日分）
package com.example.beer.model;

import java.util.Map;

public class AnalyticsPredictionDetail {
    private String date;
    private int weekday;
    private Map<String, Integer> predictions;

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public int getWeekday() { return weekday; }
    public void setWeekday(int weekday) { this.weekday = weekday; }

    public Map<String, Integer> getPredictions() { return predictions; }
    public void setPredictions(Map<String, Integer> predictions) { this.predictions = predictions; }
}
