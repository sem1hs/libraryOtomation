package com.SemihSahinoglu.library.model;

public class Book {

    private int id;
    private int bookPrice;
    private int stock;
    private String bookName;

    public Book() {
    }

    public Book(String bookName) {
        this.bookName = bookName;
    }

    public Book(int id, String bookName) {
        this.id = id;
        this.bookName = bookName;
    }

    public Book(int id,String bookName, int bookPrice, int stock) {
        this.id = id;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.stock = stock;
    }

    public Book(String bookName, int bookPrice, int stock) {
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.stock = stock;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return this.bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookPrice() {
        return this.bookPrice;
    }

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Kitap Id [" + this.id + "] - Kitap İsmi [" + this.bookName + "] - " +
                "Kitap Fiyatı [" + this.bookPrice + "] - Kitap Stok [" + this.stock + "]";
    }
}
