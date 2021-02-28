package com.home.twoDatabaseTransaction.repo;

import com.home.twoDatabaseTransaction.entities.CatDoc;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface MongoReactiveRepositoryImpl extends ReactiveMongoRepository<CatDoc, ObjectId> {
    Flux<CatDoc> findByName(String name);
    Flux<CatDoc> findByNameAndVisibleIsTrue(String name);
}
