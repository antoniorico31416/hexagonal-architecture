package com.course.hexagonal.architecture.adapters.out.db.mysql.repository.book;

import com.course.hexagonal.architecture.adapters.out.db.mysql.entity.BookItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookItemEntity, Long> {

    List<BookItemEntity> findAll();
}
