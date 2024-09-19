package com.example.springapi.service;

import com.example.springapi.api.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private List<Book> bookList;

    public BookService() {
        bookList = new ArrayList<>();

        Book book0 = new Book(0, "Emily Bronte", "Wuthering Heights", "Lame", "2024-10-12");
        Book book1 = new Book(1, "Emily Bronte", "Wuthering Heights", "Lame", "2024-10-12");
        Book book2 = new Book(2, "Emily Bronte", "Wuthering Heights", "Lame", "2024-10-12");
        Book book3 = new Book(3, "Emily Bronte", "Wuthering Heights", "Lame", "2024-10-12");
        Book book4 = new Book(4, "Emily Bronte", "Wuthering Heights", "Lame", "2024-10-12");
        Book book5 = new Book(5, "Emily Bronte", "Wuthering Heights", "Lame", "2024-10-12");
        Book book6 = new Book(6, "Emily Bronte", "Wuthering Heights", "Lame", "2024-10-12");
        Book book7 = new Book(7, "Emily Bronte", "Wuthering Heights", "Lame", "2024-10-12");
        Book book8 = new Book(8, "Emily Bronte", "Wuthering Heights", "Lame", "2024-10-12");
        Book book9 = new Book(9, "Emily Bronte", "Wuthering Heights", "Lame", "2024-10-12");

        bookList.addAll(Arrays.asList(book0, book1, book2, book3, book4, book5, book6, book7, book8, book9));
    }

    public Optional<Book> getBook(Integer id) {
        Optional<Book> optional = Optional.empty();
        for (Book book : bookList) {
            if(id == book.getId()) {
                optional = Optional.of(book);
                //Is this a justifiable break?
                break;
            }
        }
        return optional;
    }

    public List<Book> getBooks() {
        return bookList;
    }

}
