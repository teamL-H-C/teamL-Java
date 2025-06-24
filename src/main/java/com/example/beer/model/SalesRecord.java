
package com.example.beer.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sales_records")
public class SalesRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sales_date")
    private LocalDate salesDate;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;

    @OneToMany(mappedBy = "salesRecord", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<SalesDetail> details = new ArrayList<>();

    private LocalDateTime created_at;

    @ManyToOne
    @JoinColumn(name = "sales_date", referencedColumnName = "date", insertable = false, updatable = false)
    private Weather weather;

    public Long getId() { return id; }
    public LocalDate getSalesDate() { return salesDate; }
    public void setSalesDate(LocalDate salesDate) { this.salesDate = salesDate; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public List<SalesDetail> getDetails() { return details; }
    public void setDetails(List<SalesDetail> details) { this.details = details; }
    public LocalDateTime getCreatedAt() { return created_at; }
    public void setCreatedAt(LocalDateTime created_at) { this.created_at = created_at; }
    public Weather getWeather() { return weather; }
    public void setWeather(Weather weather) { this.weather = weather; }
    public void addDetail(SalesDetail detail) {
        details.add(detail);
        detail.setSalesRecord(this);
    }
}