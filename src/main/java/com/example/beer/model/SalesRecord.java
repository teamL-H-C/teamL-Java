package com.example.beer.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;
import java.rmi.registry.LocateRegistry;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "sales_records")
public class SalesRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate sales_date;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;

    @OneToMany(mappedBy = "salesRecord", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<SalesDetail> details = new ArrayList<>();

    private LocalDateTime created_at;

    public SalesRecord() {
    }

    public List<SalesDetail> getDetails() {
        return details;
    }

}
