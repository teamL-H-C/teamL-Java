package com.example.beer.repository;

import com.example.beer.model.SalesDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesDetailRepository extends JpaRepository<SalesDetail, Long> {
    
}
