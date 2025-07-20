package com.SemihSahinoglu.library.service;

import com.SemihSahinoglu.library.model.Book;
import com.SemihSahinoglu.library.repository.BookRepository;

import java.util.List;

public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return this.bookRepository.findAllBooks();
    }

    public Book getBookById(int id) {
        return this.bookRepository.findBookById(id);
    }

    public Book saveBook(Book book) {
        return this.bookRepository.createBook(book);
    }

    public String deleteAllBooks() {
        this.bookRepository.clearAllBooks();
        return "Books successfully deleted";
    }

    public String deleteBookById(int id){
        this.bookRepository.clearBookById(id);
        return "Book successfully deleted";
    }

}
