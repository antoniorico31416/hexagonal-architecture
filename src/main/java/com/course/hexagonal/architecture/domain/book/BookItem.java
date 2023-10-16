package com.course.hexagonal.architecture.domain.book;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class BookItem extends Book{
    private int availableCopies;

    public boolean isAvailable(){
        return availableCopies > 0;
    }
}
