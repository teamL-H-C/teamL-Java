// AnalyticsResponse.java（全体）
package com.example.beer.model;

import java.util.List;
import java.util.Map;

public class AnalyticsResponse {
    private String start_date;
    private Map<String, Object> shipment_summary;
    private List<AnalyticsPredictionDetail> daily_details;
    private Map<String, Object> performance_metrics;
    private String comment;

    public String getStart_date() { return start_date; }
    public void setStart_date(String start_date) { this.start_date = start_date; }

    public Map<String, Object> getShipment_summary() { return shipment_summary; }
    public void setShipment_summary(Map<String, Object> shipment_summary) { this.shipment_summary = shipment_summary; }

    public List<AnalyticsPredictionDetail> getDaily_details() { return daily_details; }
    public void setDaily_details(List<AnalyticsPredictionDetail> daily_details) { this.daily_details = daily_details; }

    public Map<String, Object> getPerformance_metrics() { return performance_metrics; }
    public void setPerformance_metrics(Map<String, Object> performance_metrics) { this.performance_metrics = performance_metrics; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }
}
