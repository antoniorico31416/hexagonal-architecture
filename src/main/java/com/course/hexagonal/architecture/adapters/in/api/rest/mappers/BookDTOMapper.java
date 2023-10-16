package com.course.hexagonal.architecture.adapters.in.api.rest.mappers;

import com.course.hexagonal.architecture.adapters.in.api.rest.dtos.BookItemDTO;
import com.course.hexagonal.architecture.domain.book.BookItem;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookDTOMapper {
    BookItem toDomainModel(BookItemDTO bookItemEntity);

    List<BookItem> toDomainModel(List<BookItemDTO> bookItemEntities);

    BookItemDTO toDomainEntity(BookItem bookItem);
}
