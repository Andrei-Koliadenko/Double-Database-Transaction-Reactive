package com.home.twoDatabaseTransaction.repo;

import com.home.twoDatabaseTransaction.entities.CatTable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostgresqlReactiveRepositoryImpl extends ReactiveCrudRepository<CatTable, String> {

}
