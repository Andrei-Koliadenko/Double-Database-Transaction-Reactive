package com.home.twoDatabaseTransaction;

import com.home.twoDatabaseTransaction.dto.Breed;
import com.home.twoDatabaseTransaction.dto.CatDtoWithId;
import com.home.twoDatabaseTransaction.entities.CatTable;
import com.home.twoDatabaseTransaction.mapper.CatMapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MapStructTests {
    @Test
    @Order(1)
    public void CatMapStruct_toCatDto_AllFieldsShouldBeEquals() {
        CatTable cat = new CatTable("1", "name", 1, "Siamese");
        CatDtoWithId mappedCat = CatMapper.INSTANCE.toCatDto(cat);
        assertEquals("1", mappedCat.getId());
        assertEquals("name", mappedCat.getName());
        assertEquals(1, mappedCat.getAge());
        assertEquals(Breed.Siamese, mappedCat.getBreed());
    }

    @Test
    @Order(2)
    public void CatMapStruct_toCatDto_ShouldBeIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            CatTable cat = new CatTable("1", "name", 1, "unknown");
            CatMapper.INSTANCE.toCatDto(cat);
        });
    }

}
