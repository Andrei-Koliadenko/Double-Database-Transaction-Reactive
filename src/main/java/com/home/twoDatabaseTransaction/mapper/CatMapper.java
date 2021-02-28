package com.home.twoDatabaseTransaction.mapper;

import com.home.twoDatabaseTransaction.dto.CatDto;
import com.home.twoDatabaseTransaction.dto.CatDtoWithId;
import com.home.twoDatabaseTransaction.entities.CatDoc;
import com.home.twoDatabaseTransaction.entities.CatTable;
import org.bson.types.ObjectId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import reactor.core.publisher.Mono;

@Mapper
public interface CatMapper {
    CatMapper INSTANCE = Mappers.getMapper(CatMapper.class);

    @Mapping(source = "catId", target = "_id")
    CatDoc toCatDoc(CatDto cat, ObjectId catId);

    @Mapping(source = "id", target = "id")
    CatTable toCatTable(CatDto cat, String id);
//
//    @Mapping(source = "_id.toHexString", target = "id")
//    CatDtoWithId toCatDto(CatDoc cat);

    CatDtoWithId toCatDto(CatTable cat);

//    @Mapping(source = "_id.toHexString", target = "id")
//    Mono<CatDtoWithId> toCatDto(Mono<CatDoc> cat);
}
