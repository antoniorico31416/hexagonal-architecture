package com.course.hexagonal.architecture.adapters.out.db.mysql.mappers;

import com.course.hexagonal.architecture.adapters.out.db.mysql.entity.BookItemEntity;
import com.course.hexagonal.architecture.domain.book.BookItem;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookIMapper {

    BookItem toDomainModel(BookItemEntity bookItemEntity);

    List<BookItem> toDomainModel(List<BookItemEntity> bookItemEntities);

    BookItemEntity toDomainEntity(BookItem bookItem);

}
