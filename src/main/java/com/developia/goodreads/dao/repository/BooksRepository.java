package com.developia.goodreads.dao.repository;

import com.developia.goodreads.dao.entity.BooksEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<BooksEntity, Long> {
}
