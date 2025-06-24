// --- Weather.java ---
package com.example.beer.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "weather")
public class Weather {
    @Id
    @Column(name = "date")
    private LocalDate date;

    private String condition;
    private Double temperature;

    public LocalDate getDate() { return date; }
    public String getCondition() { return condition; }
    public Double getTemperature() { return temperature; }
}