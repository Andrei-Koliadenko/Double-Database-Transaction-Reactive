package com.home.twoDatabaseTransaction.service;

import com.home.twoDatabaseTransaction.dto.Breed;
import com.home.twoDatabaseTransaction.dto.CatDto;
import com.home.twoDatabaseTransaction.dto.CatDtoWithId;
import com.home.twoDatabaseTransaction.entities.CatDoc;
import com.home.twoDatabaseTransaction.entities.CatTable;
import com.home.twoDatabaseTransaction.mapper.CatMapper;
import com.home.twoDatabaseTransaction.repo.MongoReactiveRepositoryImpl;
import com.home.twoDatabaseTransaction.repo.PostgresqlReactiveRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DoubleDatabaseTransactionService {
    private final MongoReactiveRepositoryImpl mongoRepository;
    private final PostgresqlReactiveRepositoryImpl postgresqlRepository;

    @Transactional
    public Mono<CatDoc> addCat(CatDto cat) {
//        String id = new ObjectId().toHexString();
//        CatTable catTable = CatMapper.INSTANCE.toCatTable(cat, id);
//        CatDoc catDoc = CatMapper.INSTANCE.toCatDoc(cat, id);
//        Mono<CatTable> catTableSaved = postgresqlRepository.save(catTable);
//        Mono<CatDoc> catDocSaved = mongoRepository.save(catDoc);
        //return Mono.just();
//        return Mono.empty();
        ObjectId id = new ObjectId();
        CatDoc catDoc = CatMapper.INSTANCE.toCatDoc(cat, id);
        //Mono<CatDoc> catDocSaved = mongoRepository.save(catDoc);
        //System.out.println(catDocSaved.block().toString());
        return mongoRepository.save(catDoc);
    }

    public Mono<CatDtoWithId> getCatById(String id) {
//        CatTable catTableGood = new CatTable("1", "name", 1, "Siamese");
//        System.out.println(catTableGood);
//        CatDtoWithId cat = CatMapper.INSTANCE.toCatDto(catTableGood);
//        System.out.println(cat);
        return Mono.just(new CatDtoWithId("Purr", 1, Breed.Siamese, id, true));
    }

    public Flux<CatDoc> getAllCats() {
        //Flux<CatTable> catsTable = postgresqlRepository.findAll();
        //Flux<CatDtoWithId> cats =  catsTable.toStream().flatMap(catTable -> catsTable.);
        //CatDtoWithId cat1 = new CatDtoWithId("Purr", 1, Breed.Siamese, "1");
        //CatDtoWithId cat2 = new CatDtoWithId("Purr", 3, Breed.Abyssinian, "2");
        //return Flux.just(cat1, cat2);
        return mongoRepository.findAll();
    }

    public Flux<CatDoc> getCatByName(String name) {

        return mongoRepository.findByName(name);
    }

    public Flux<CatDoc> getCatByNameVisible(String name) {

        return mongoRepository.findByNameAndVisibleIsTrue(name);
    }
}
