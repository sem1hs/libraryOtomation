package com.SemihSahinoglu.library.repository;

import com.SemihSahinoglu.library.model.Book;
import com.SemihSahinoglu.library.util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    public List<Book> findAllBooks() {
        List<Book> bookList = new ArrayList<>();
        String query = "SELECT * FROM books";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(query);
             ResultSet rs = statement.executeQuery()
        ) {
            while (rs.next()) {
                int bookId = rs.getInt("id");
                String bookName = rs.getString("book_name");
                int bookPrice = rs.getInt("book_price");
                int stock = rs.getInt("stock");

                Book book = new Book(bookId, bookName, bookPrice, stock);
                bookList.add(book);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return bookList;
    }

    public Book findBookById(int bookId) {
        String query = "SELECT * FROM books WHERE id = ?";
        Book book = null;

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(query);
        ) {
            statement.setInt(1, bookId);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String bookName = rs.getString("book_name");
                book = new Book(id, bookName);
            }

            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return book;
    }

    public Book createBook(Book book) {
        String query = "INSERT INTO books (book_name) VALUES (?)";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setString(1, book.getBookName());
            int affectRows = statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return book;
    }

    public void clearAllBooks() {
        String query = "TRUNCATE TABLE books RESTART IDENTITY CASCADE";

        try (
                Connection conn = DbConnection.getConnection();
                PreparedStatement statement = conn.prepareStatement(query);
        ) {
            int affectRows = statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
