package com.home.twoDatabaseTransaction.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "cats")
public class CatTable {
    @Id
    private String id;

    @NotBlank(message = "Name may not be empty")
    private String name;

    @NotNull(message = "Age may not be empty")
    @Min(value = 1, message = "Minimal age may be greater than or equal to 1")
    private int age;

    @NotBlank(message = "Breed may not be empty")
    private String breed;
}
