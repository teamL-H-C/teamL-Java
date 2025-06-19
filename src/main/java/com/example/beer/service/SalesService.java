package com.example.beer.service;

import com.example.beer.model.SalesRecord;
import com.example.beer.repository.SalesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalesService {

    private final SalesRepository salesRepository;

    public SalesService(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
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
