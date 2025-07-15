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

    public Book saveBook(Book book) {
        return this.bookRepository.createBook(book);
    }

    public Book getBookById(int id){
        return this.bookRepository.findBookById(id);
    }

    public void deleteAllBooks(){
        this.bookRepository.clearAllBooks();
    }
}
