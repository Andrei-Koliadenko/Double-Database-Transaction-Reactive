package com.home.twoDatabaseTransaction.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class CatDtoWithId extends CatDto{
    private String id;

    public CatDtoWithId(String name, int age, Breed breed, String id, Boolean visible) {
        super(name, age, breed, visible);
        this.id = id;
    }
}
