package com.example.crudbibliotecatwo.controller;

import com.example.crudbibliotecatwo.entity.Book;
import com.example.crudbibliotecatwo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAll() {
        return bookService.getBooks();
    }

    @PostMapping
    public void saveOrUpdate(@RequestBody Book book) {
        bookService.saveOrUpdate(book);
    }

    @DeleteMapping("/{bookId}")
    public void delete(@PathVariable("bookId") Long bookId) {
        bookService.delete(bookId);
    }

    @GetMapping("/{bookId}")
    public Optional<Book> getById(@PathVariable("bookId") Long bookId) {
        return bookService.getBook(bookId);
    }

    @PutMapping("/{bookId}")
    public Book updateBookById(@PathVariable("bookId") Long bookId, @RequestBody Book bookDetails){
        return bookService.updateBook(bookId, bookDetails);
    }
}
