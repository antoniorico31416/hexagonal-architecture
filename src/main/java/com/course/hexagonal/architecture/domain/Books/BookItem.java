package com.course.hexagonal.architecture.domain.Books;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookItem extends Book{
    private int availableCopies;

    public boolean isAvailable(){
        return availableCopies > 0;
    }
}
