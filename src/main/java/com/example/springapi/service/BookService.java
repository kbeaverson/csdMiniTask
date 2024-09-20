package com.example.springapi.service;

import com.example.springapi.api.model.Book;
import com.example.springapi.api.model.BookWithId;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {

    private List<BookWithId> books;
    public BookService() {
        this.books = new ArrayList<BookWithId>();
        fillWithRandomData();
    }

    /**
     * Returns {BookWithId} for a given [id], if it exists.
     * @param id - the id of a desired {BookWithId}.
     * @return {BookWithId} if [id] is present in list of books, else empty optional.
     */
    public Optional<BookWithId> getBook(Integer id) {
        Optional<BookWithId> optional = Optional.empty();
        for (BookWithId book : books) {
            if(Objects.equals(id, book.getId())) {
                optional = Optional.of(book);
                //Is this a justifiable break?
                break;
            }
        }
        return optional;
    }

    /**
     * Provides the list of {BookWithId} stored in [this.books].
     * @return list of {BookWithId} books stored.
     */
    public List<BookWithId> getBooks() {
        return books;
    }

    /**
     * Adds [newBook] to this.books
     * @param newBook {Book} to be added to this.books
     * @return {BookWithId} value added to this.books
     */
    public BookWithId addBook(Book newBook) {
        BookWithId addedBook = new BookWithId(newBook.getTitle(), newBook.getAuthor(), newBook.getSynopsis(), newBook.getReleaseDate());
        books.add(addedBook);
        return addedBook;
    }

    /**
     * Updates {BookWithId} with id == [id] with [book] if present.
     * @param id id of the {BookWithId} to be updated
     * @param book {Book} with new data for the {BookWithId} with id == [id]
     * @return the updated {BookWithId} with id == [id] if present, else empty optional.
     */
    public Optional<BookWithId> updateBook (Integer id, Book book) {
        for(BookWithId bookWID : books) {
            if (Objects.equals(bookWID.getId(), id)) {
                bookWID.setAuthor(book.getAuthor());
                bookWID.setTitle(book.getTitle());
                bookWID.setSynopsis(book.getSynopsis());
                bookWID.setReleaseDate(book.getReleaseDate());
                return Optional.of(bookWID);
            }
        }
        return Optional.empty();
    }

    /**
     * Deletes the {BookWithId} with id == [id] from this.books, if present
     * @param id the id of the book to be deleted
     * @return Optional containing the {BookWithId} that was deleted if present, else and empty optional
     */
    public Optional<BookWithId> deleteBook(Integer id) {
        for (BookWithId book : books) {
            if (Objects.equals(book.getId(), id)) {
                books.remove(book);
                return Optional.of(book);
            }
        }
        return Optional.empty();
    }

    /**
     * Fills this.books with random book data.
     */
    private void fillWithRandomData() {
        books.add(new BookWithId("To Kill a Mockingbird", "Harper Lee",
                "A young girl named Scout growing up in the racially charged American South learns about justice and compassion.",
                "1960-07-11"));

        books.add(new BookWithId("1984", "George Orwell",
                "A dystopian novel about a totalitarian regime under Big Brother's surveillance and mind control.",
                "1949-06-08"));

        books.add(new BookWithId("Moby-Dick", "Herman Melville",
                "The story of Captain Ahab's obsessive quest to kill the white whale, Moby Dick.",
                "1851-10-18"));

        books.add(new BookWithId("Pride and Prejudice", "Jane Austen",
                "The romantic clash between the opinionated Elizabeth Bennet and the wealthy Mr. Darcy.",
                "1813-01-28"));

        books.add(new BookWithId("The Great Gatsby", "F. Scott Fitzgerald",
                "A story of the mysterious Jay Gatsby and his unrequited love for Daisy Buchanan in the Roaring Twenties.",
                "1925-04-10"));

        books.add(new BookWithId("The Catcher in the Rye", "J.D. Salinger",
                "The experiences of Holden Caulfield, a disillusioned teenager navigating life in New York.",
                "1951-07-16"));

        books.add(new BookWithId("The Hobbit", "J.R.R. Tolkien",
                "Bilbo Baggins embarks on an unexpected journey filled with adventure and peril to recover a stolen treasure.",
                "1937-09-21"));

        books.add(new BookWithId("Harry Potter and the Philosopher's Stone", "J.K. Rowling",
                "An orphaned boy discovers he is a wizard and begins his magical education at Hogwarts.",
                "1997-06-26"));

        books.add(new BookWithId("The Lord of the Rings: The Fellowship of the Ring", "J.R.R. Tolkien",
                "A group of unlikely companions set out to destroy a powerful ring to stop the dark lord Sauron.",
                "1954-07-29"));

        books.add(new BookWithId("The Chronicles of Narnia: The Lion, the Witch and the Wardrobe", "C.S. Lewis",
                "Four siblings discover a magical land where they join the fight to defeat an evil witch.",
                "1950-10-16"));
    }

}
