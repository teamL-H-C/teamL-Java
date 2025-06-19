package com.example.beer.model;

import jakarta.persistence.*;

@Entity
@Table(name = "sales_details")
public class SalesDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "records_id")
    private SalesRecord salesRecord;

    @ManyToOne
    @JoinColumn(name = "beers_id")
    private Beer beer;

    public SalesDetail() {}
}
