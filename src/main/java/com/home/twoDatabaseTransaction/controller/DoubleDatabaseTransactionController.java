package com.home.twoDatabaseTransaction.controller;

import com.home.twoDatabaseTransaction.dto.CatDto;
import com.home.twoDatabaseTransaction.dto.CatDtoWithId;
import com.home.twoDatabaseTransaction.service.DoubleDatabaseTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class DoubleDatabaseTransactionController {
    private final DoubleDatabaseTransactionService service;

    @PostMapping("/cat/add")
    public Mono<CatDtoWithId> addCat(@RequestParam CatDto cat) {
        return service.addCat(cat);
    }

    @GetMapping("/cat/{id}")
    public Mono<CatDtoWithId> getCatById(@PathVariable String id) {
        return service.getCatById(id);
    }

    @GetMapping("/cats")
    public Flux<CatDtoWithId> getAllCats() {
        return service.getAllCats();
    }
}
