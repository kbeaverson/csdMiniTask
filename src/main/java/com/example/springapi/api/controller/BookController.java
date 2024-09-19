package com.example.springapi.api.controller;

import com.example.springapi.api.model.Book;
import com.example.springapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/book")
    public Book getUser(@RequestParam Integer id){
        Optional book = bookService.getBook(id);
        if(book.isPresent()) {
            return (Book) book.get();
        }
        //This is back code ^V, but following tutorial
        return null;
    }

    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

}
