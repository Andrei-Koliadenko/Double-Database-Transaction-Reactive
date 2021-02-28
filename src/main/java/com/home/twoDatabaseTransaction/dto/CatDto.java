package com.home.twoDatabaseTransaction.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class CatDto {
    private String name;
    private int age;
    private Breed breed;
    private Boolean visible;
}
