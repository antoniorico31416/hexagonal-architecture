package com.course.hexagonal.architecture.adapters.out.db.mysql.entity;

import com.course.hexagonal.architecture.domain.book.BookState;
import com.course.hexagonal.architecture.domain.book.GenreBook;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "BookItem")
public class BookItemEntity {
    @Id
    @Column(name = "isbn")
    private long isbn;

    private String title;
    private String author;

    @Enumerated(EnumType.STRING)
    private GenreBook genre;

    @Enumerated(EnumType.STRING)
    private BookState state;

    private int availableCopies;
}
