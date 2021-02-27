package com.home.twoDatabaseTransaction.repo;

import com.home.twoDatabaseTransaction.entities.CatDoc;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoReactiveRepositoryImpl extends ReactiveMongoRepository<CatDoc, String> {

}
