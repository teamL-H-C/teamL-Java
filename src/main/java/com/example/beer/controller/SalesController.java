package com.example.beer.controller;

import com.example.beer.model.SalesDetail;
import com.example.beer.service.SalesService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/sales")
public class SalesController {

    private final SalesService salesService;

    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    @GetMapping
    public String showSales(@RequestParam(required = false)
                            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
                            Model model) {

        List<SalesDetail> details = (date != null)
            ? salesService.findDetailsByDate(date)
            : salesService.findDetailAll();

        // null の SalesRecord を除外
        Map<LocalDate, List<SalesDetail>> grouped = details.stream()
            .filter(detail -> detail.getSalesRecord() != null)
            .collect(Collectors.groupingBy(
                d -> d.getSalesRecord().getSalesDate(),
                TreeMap::new,
                Collectors.toList()
            ));

        model.addAttribute("selectedDate", date);
        model.addAttribute("groupedSales", grouped);
        return "sales/list";
    }
}