package com.SemihSahinoglu.library;

import com.SemihSahinoglu.library.model.Book;
import com.SemihSahinoglu.library.repository.BookRepository;
import com.SemihSahinoglu.library.service.BookService;

public class Main {
    public static BookRepository bookRepository = new BookRepository();
    public static BookService bookService = new BookService(bookRepository);

    public static void main(String[] args) {
        bookService.getAllBooks().forEach(System.out::println);

    }
}
