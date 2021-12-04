package com.developia.goodreads.service;

import com.developia.goodreads.dao.entity.BooksEntity;
import com.developia.goodreads.dao.repository.BooksRepository;
import com.developia.goodreads.model.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private BooksRepository booksRepository;

    public BookService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<BooksEntity> getBooks() {
        List<BooksEntity> books = booksRepository.findAll();

        return books;
    }

    public BooksEntity getBook(Long id) {
        BooksEntity book = booksRepository.findById(id)
                .orElseThrow(() -> {
                    throw new NotFoundException("Book not found");
                });

        return book;
    }
}
