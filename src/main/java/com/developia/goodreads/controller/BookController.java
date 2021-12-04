package com.developia.goodreads.controller;

import com.developia.goodreads.dao.entity.BooksEntity;
import com.developia.goodreads.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/books") //http://localhost:8080/books dushecek bu controllere
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping //http://localhost:8080/books HTTP GET sorgu dushecek bu metoda
    public String getBooks(Model model) {
        List<BooksEntity> books = bookService.getBooks();

        model.addAttribute("books", books);

        return "book-list";
    }

    //http://localhost:8080/books/1 HTTP GET sorgu dushecek bu metoda. 1 yerine istenilen reqem ola biler
    @GetMapping(value = "/{id}")
    public String getBook(@PathVariable(name = "id") Long id, Model model) {
        BooksEntity book = bookService.getBook(id);

        model.addAttribute("book", book);

        return "book";
    }
}
