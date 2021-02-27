package com.home.twoDatabaseTransaction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.home.twoDatabaseTransaction.dto.Breed;
import com.home.twoDatabaseTransaction.dto.CatDtoWithId;
import com.home.twoDatabaseTransaction.repo.PostgresqlReactiveRepositoryImpl;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
class DoubleDatabaseTransactionApplicationTests {
    @Autowired
    private PostgresqlReactiveRepositoryImpl postgresRepository;

    @Autowired
    private MockMvc mock;

    @BeforeAll
    static void addCatToDatabases() {
        //CatDtoWithId cat1 = new CatDtoWithId("Purr", 1, Breed.Siamese, "1");
        //CatDtoWithId cat2 = new CatDtoWithId("Purr", 3, Breed.Abyssinian, "2");
    }

    @AfterAll
    static void deleteCatFromDatabases() {

    }

    @Test
    void contextLoads() {
    }

    @Test
    public void getCatById_ExpectStatusOkAndAssertEqualsByAllFields() throws Exception {
        ResultActions actions = mock.perform(get("http://localhost:8080/cat/sssss"));
        //actions.andExpect(status().isOk()).andExpect(content().contentType(contentType));
        String responseBody = actions.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        System.out.println("MYYYYYYYYYYYYYYYYYYYYY " + responseBody);
//        CatDtoWithId cat = new ObjectMapper().readValue(responseBody, CatDtoWithId.class);
//        assertEquals("1", cat.getId());
//        assertEquals("Purr", cat.getName());
//        assertEquals(1, cat.getAge());
//        assertEquals(Breed.Siamese, cat.getBreed());
    }
}
