package com.example.beer.controller;

import com.example.beer.model.SalesRecord;
import com.example.beer.service.SalesService;
import com.example.beer.service.BeerService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("salesList", salesService.findAll());
        return "sales/list";
    }

    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("salesRecord", new SalesRecord());
        model.addAttribute("beerList", beerService.findAll());
        return "sales/form";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute SalesRecord record) {
        salesService.save(record);
        return "redirect:/sales";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        SalesRecord record = salesService.findById(id).orElseThrow();
        model.addAttribute("salesRecord", record);
        model.addAttribute("beerList", beerService.findAll());
        return "sales/form";
    }

    @PostMapping("/{id}/edit")
    public String update(@ModelAttribute SalesRecord record) {
        salesService.save(record);
        return "redirect:/sales";
    }
}

