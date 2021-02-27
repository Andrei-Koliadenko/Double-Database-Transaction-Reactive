package com.home.twoDatabaseTransaction.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DoubleDatabaseTransactionController {
    DoubleDatabaseTransactionService service;

    @PostMapping("/cat/add")
    public CatDtoWithId addCat(@RequestParam CatDto cat) {
        return service.addCat(cat);
    }

    @GetMapping("/cat/{id}")
    public CatDtoWithId getCatById(@RequestParam String id) {
        return service.getCatById(id);
    }

    @GetMapping("/cats")
    public List<CatDtoWithId> getAllCats() {
        return service.getAllCats();
    }
}
