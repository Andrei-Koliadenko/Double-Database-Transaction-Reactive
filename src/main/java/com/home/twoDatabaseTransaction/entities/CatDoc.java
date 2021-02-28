package com.home.twoDatabaseTransaction.entities;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Document(collection = "cats")
public class CatDoc {
    ObjectId _id;

    @NotBlank(message = "Name may not be empty")
    String name;

    @NotNull(message = "Age may not be empty")
    @Min(value = 1, message = "Minimal age may be greater than or equal to 1")
    int age;

    @NotBlank(message = "Breed may not be empty")
    String breed;

    @NotNull(message = "Visible may not be null")
    Boolean visible;
}
