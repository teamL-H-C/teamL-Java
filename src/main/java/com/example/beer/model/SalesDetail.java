package com.example.beer.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "sales_details")
public class SalesDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "records_id")
    private SalesRecord salesRecord;

    @ManyToOne
    @JoinColumn(name = "beers_id")
    private Beer beer;

    private Integer quantity;

    private LocalDateTime date;

    public SalesDetail() {}

    // --- Getter ---
    public Long getId() {
        return id;
    }

    public SalesRecord getSalesRecord() {
        return salesRecord;
    }

    public Beer getBeer() {
        return beer;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public LocalDateTime getDateTime() {
        return date;
    }

    // ✔ グルーピング用（LocalDateだけ取り出す）
    public LocalDate getDate() {
        return date.toLocalDate();
    }

    public void setSalesRecord(SalesRecord salesRecord) {
        this.salesRecord = salesRecord;
    }

    public void setBeer(Beer beer) {
        this.beer = beer;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
