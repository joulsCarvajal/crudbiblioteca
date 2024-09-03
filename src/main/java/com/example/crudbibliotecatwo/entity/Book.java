package com.example.crudbibliotecatwo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    private String tittle;
    private String author;
    private String pubAge;
    private String isbn;

}
