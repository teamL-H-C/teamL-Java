package com.example.beer.model;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name; // 例: "ROLE_ADMIN" または "ROLE_STAFF"

    public Role() {}
    public Role(String name) {
        this.name = name;
    }

    public Integer getId() { return id; }
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}
