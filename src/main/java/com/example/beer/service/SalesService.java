package com.example.beer.service;

import com.example.beer.model.SalesDetail;
import com.example.beer.model.SalesRecord;
import com.example.beer.repository.SalesDetailRepository;
import com.example.beer.repository.SalesRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalesService {

    private final SalesRecordRepository salesRepository;
    private final SalesDetailRepository salesDetailRepository;

    public SalesService(SalesRecordRepository salesRepository,
                        SalesDetailRepository salesDetailRepository) {
        this.salesRepository = salesRepository;
        this.salesDetailRepository = salesDetailRepository;
    }

    public List<SalesDetail> findDetailAll() {
        return salesDetailRepository.findAll();
    }

    public List<SalesRecord> findAll() {
        return salesRepository.findAll();
    }

    public Optional<SalesRecord> findById(Long id) {
        return salesRepository.findById(id);
    }

    public SalesRecord save(SalesRecord record) {
        return salesRepository.save(record);
    }

    public void delete(Long id) {
        salesRepository.deleteById(id);
    }
}
