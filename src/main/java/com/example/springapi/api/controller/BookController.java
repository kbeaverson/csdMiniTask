package com.example.springapi.api.controller;

import com.example.springapi.api.model.Book;
import com.example.springapi.api.model.BookWithId;
import com.example.springapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/book")
    public BookWithId getBook(@RequestParam Integer id) {
        Optional<BookWithId> book = bookService.getBook(id);
        return (BookWithId) book.orElse(null);
        //This is bad code ^V, but following tutorial
    }

    @GetMapping("/books")
    public List<BookWithId> getBooks() {
        return bookService.getBooks();
    }

    @PostMapping("/books")
    public ResponseEntity<BookWithId> addBook(@RequestBody Book newBook) {
        BookWithId added = bookService.addBook(newBook);
        return ResponseEntity.ok(added);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable String id, @RequestBody Book book) {
        System.out.println("Input method");
        int idAsInt = Integer.parseInt(id);
        Optional<BookWithId> updatedBook = bookService.updateBook(idAsInt, book);
        System.out.println(updatedBook);
        if (updatedBook.isPresent()) {
            return ResponseEntity.ok(book);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<BookWithId> deleteBook(@PathVariable String id) {
        int idAsInt = Integer.parseInt(id);
        Optional<BookWithId> deletedBook = bookService.deleteBook(idAsInt);
        if (deletedBook.isPresent()) {
            return ResponseEntity.of(deletedBook);
        }
        return ResponseEntity.notFound().build();
    }
}
