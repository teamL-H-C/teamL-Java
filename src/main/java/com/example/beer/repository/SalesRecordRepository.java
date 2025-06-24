package com.example.beer.repository;

import com.example.beer.model.SalesRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SalesRecordRepository extends JpaRepository<SalesRecord, Long> {
    List<SalesRecord> findBySalesDate(LocalDate date);
    List<SalesRecord> findBySalesDateBetween(LocalDate start, LocalDate end);
}
