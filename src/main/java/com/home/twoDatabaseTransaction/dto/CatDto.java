package com.home.twoDatabaseTransaction.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CatDto {
    private String name;
    private int age;
    private Breed breed;
}
