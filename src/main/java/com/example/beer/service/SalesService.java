package com.example.beer.service;

import com.example.beer.model.SalesDetail;
import com.example.beer.model.SalesRecord;
import com.example.beer.repository.SalesDetailRepository;
import com.example.beer.repository.SalesRecordRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SalesService {

    private final SalesRecordRepository salesRecordRepository;
    private final SalesDetailRepository salesDetailRepository;

    public SalesService(SalesRecordRepository salesRecordRepository,
                        SalesDetailRepository salesDetailRepository) {
        this.salesRecordRepository = salesRecordRepository;
        this.salesDetailRepository = salesDetailRepository;
    }

    public List<SalesDetail> findDetailAll() {
        return salesDetailRepository.findAll().stream()
                .filter(detail -> detail.getSalesRecord() != null)
                .collect(Collectors.toList());
    }

    public List<SalesDetail> findDetailsByDate(LocalDate date) {
        return salesDetailRepository.findBySalesRecord_SalesDate(date).stream()
                .filter(detail -> detail.getSalesRecord() != null)
                .collect(Collectors.toList());
    }

    public List<SalesRecord> findAllRecords() {
        return salesRecordRepository.findAll();
    }

    public Optional<SalesRecord> findRecordById(Long id) {
        return salesRecordRepository.findById(id);
    }

    public SalesRecord saveRecord(SalesRecord record) {
        return salesRecordRepository.save(record);
    }

    public void deleteRecord(Long id) {
        salesRecordRepository.deleteById(id);
    }

    public List<SalesRecord> findRecordsByDate(LocalDate date) {
        return salesRecordRepository.findBySalesDate(date);
    }

    public List<SalesRecord> findRecordsBetween(LocalDate start, LocalDate end) {
        return salesRecordRepository.findBySalesDateBetween(start, end);
    }
}