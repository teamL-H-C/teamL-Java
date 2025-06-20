package com.example.beer.model;

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

    public SalesDetail() {
    }

    public Integer getQuantity() {
        return quantity;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
