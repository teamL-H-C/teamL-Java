package com.example.beer.repository;

import com.example.beer.model.SalesDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SalesDetailRepository extends JpaRepository<SalesDetail, Long> {
    List<SalesDetail> findBySalesRecord_SalesDate(LocalDate salesDate);
}