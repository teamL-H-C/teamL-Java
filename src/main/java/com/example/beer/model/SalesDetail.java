package com.example.beer.model;

import jakarta.persistence.*;

@Entity
@Table(name = "sales_details")
public class SalesDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "records_id", nullable = false)
    private SalesRecord salesRecord;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "beers_id", nullable = false)
    private Beer beer;

    private Integer quantity;

    public SalesDetail() {}

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

    public java.time.LocalDate getDate() {
        return (salesRecord != null) ? salesRecord.getSalesDate() : null;
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
}
