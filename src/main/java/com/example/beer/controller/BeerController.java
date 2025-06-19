package com.example.beer.controller;

import com.example.beer.model.Beer;
import com.example.beer.service.BeerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/beers")
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    // 商品一覧
    @GetMapping
    public String list(Model model) {
        model.addAttribute("beerList", beerService.findAll());
        return "beers/list";
    }

    // 新規登録フォーム
    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("beer", new Beer());
        return "beers/form";
    }

    // 登録処理
    @PostMapping("/new")
    public String create(@ModelAttribute Beer beer) {
        beerService.save(beer);
        return "redirect:/beers";
    }

    // 編集フォーム
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        Optional<Beer> beer = beerService.findById(id);
        if (beer.isPresent()) {
            model.addAttribute("beer", beer.get());
            return "beers/form"; // または edit.html
        }
        return "redirect:/beers";
    }

    // 編集保存処理
    @PostMapping("/{id}/edit")
    public String update(@ModelAttribute Beer beer) {
        beerService.save(beer);
        return "redirect:/beers";
    }
}
