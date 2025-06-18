package com.example.beer.service;

import com.example.beer.model.Beer;
import com.example.beer.repository.BeerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BeerService {

    private final BeerRepository beerRepository;

    public BeerService(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    public List<Beer> findAll() {
        return beerRepository.findAll();
    }

    public Optional<Beer> findById(Long id) {
        return beerRepository.findById(id);
    }

    public void save(Beer beer) {
        beerRepository.save(beer);
    }
}
