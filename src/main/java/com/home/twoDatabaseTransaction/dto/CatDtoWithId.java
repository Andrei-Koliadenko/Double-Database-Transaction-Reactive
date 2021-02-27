package com.home.twoDatabaseTransaction.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CatDtoWithId extends CatDto{
    private String id;

    public CatDtoWithId(String id, String name, int age, Breed breed) {
        super(name, age, breed);
        this.id = id;
    }
}
