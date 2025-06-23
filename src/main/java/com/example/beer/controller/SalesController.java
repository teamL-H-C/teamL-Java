package com.example.beer.controller;

import com.example.beer.model.SalesDetail;
import com.example.beer.service.SalesService;
import com.example.beer.service.BeerService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/sales")
public class SalesController {

    private final SalesService salesService;
    private final BeerService beerService;

    public SalesController(SalesService salesService, BeerService beerService) {
        this.salesService = salesService;
        this.beerService = beerService;
    }

    @GetMapping
    public String list(Model model) {
        List<SalesDetail> details = salesService.findDetailAll();

        // 販売日ごとにグループ化
        Map<LocalDate, List<SalesDetail>> grouped = details.stream()
                .collect(Collectors.groupingBy(SalesDetail::getDate, TreeMap::new, Collectors.toList()));

        model.addAttribute("groupedSales", grouped);
        return "sales/list";
    }
}
