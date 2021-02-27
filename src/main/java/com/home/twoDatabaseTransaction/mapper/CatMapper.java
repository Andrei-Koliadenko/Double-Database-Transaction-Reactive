package com.home.twoDatabaseTransaction.mapper;

import com.home.twoDatabaseTransaction.dto.CatDto;
import com.home.twoDatabaseTransaction.dto.CatDtoWithId;
import com.home.twoDatabaseTransaction.entities.CatDoc;
import com.home.twoDatabaseTransaction.entities.CatTable;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CatMapper {
    CatMapper INSTANCE = Mappers.getMapper(CatMapper.class);

    @Mapping(source = "catId", target = "_id")
    CatDoc toCatDoc(CatDto cat, String catId);

    @Mapping(source = "id", target = "id")
    CatTable toCatTable(CatDto cat, String id);

    @Mapping(source = "_id", target = "id")
    CatDtoWithId toCatDto(CatDoc cat);

    CatDtoWithId toCatDto(CatTable cat);

}
