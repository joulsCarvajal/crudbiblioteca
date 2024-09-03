package com.example.crudbibliotecatwo.service;

import com.example.crudbibliotecatwo.entity.Book;
import com.example.crudbibliotecatwo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public Optional<Book> getBook(Long id){
        return bookRepository.findById(id);
    }

    public void saveOrUpdate(Book book){
        bookRepository.save(book);
    }

    public void delete(Long id){
        bookRepository.deleteById(id);
    }

    public Book updateBook(Long bookId, Book bookDetails){
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + bookId));
        book.setTittle(bookDetails.getTittle());
        book.setAuthor(bookDetails.getAuthor());
        book.setPubAge(bookDetails.getPubAge());
        book.setIsbn(book.getIsbn());

        return bookRepository.save(book);
    }
}
