package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SearchServiceTest {

    private SearchService searchService;
    private List<Book> books;

    @BeforeEach
    void setUp() {
        // Setup some sample books for testing
        books = Arrays.asList(
                new Book("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", "Scribner", 10.99, 10),
                new Book("1984", "George Orwell", "Dystopian", "Secker & Warburg", 8.99, 5),
                new Book("To Kill a Mockingbird", "Harper Lee", "Fiction", "J.B. Lippincott & Co.", 7.99, 0),
                new Book("The Catcher in the Rye", "J.D. Salinger", "Fiction", "Little, Brown and Company", 6.99, 3)
        );

        searchService = new SearchService();
    }

    @Test
    void testSearchByAuthor() {
        searchService.setSearchStrategy(new SearchByAuthor());

        List<Book> result = searchService.performSearch("F. Scott Fitzgerald", books);

        assertEquals(1, result.size());
        assertEquals("The Great Gatsby", result.get(0).getTitle());
    }

    @Test
    void testSearchByCategory() {
        searchService.setSearchStrategy(new SearchByCategory());

        List<Book> result = searchService.performSearch("Fiction", books);

        assertEquals(2, result.size());  // Two books in the Fiction category because one has availability zero
    }

    @Test
    void testSearchByTitle() {
        searchService.setSearchStrategy(new SearchByTitle());

        List<Book> result = searchService.performSearch("1984", books);

        assertEquals(1, result.size());
        assertEquals("1984", result.get(0).getTitle());
    }

    @Test
    void testSearchWithNoMatchingBooksByAuthor() {
        searchService.setSearchStrategy(new SearchByAuthor());

        List<Book> result = searchService.performSearch("J.K. Rowling", books);

        assertTrue(result.isEmpty());  // No books should be found for this author
    }

    @Test
    void testSearchWithNoAvailableBooks() {
        searchService.setSearchStrategy(new SearchByCategory());

        List<Book> result = searchService.performSearch("Fiction", books);

        assertEquals(2, result.size());  // Only two books with Fiction category are available
        assertFalse(result.stream().anyMatch(book -> book.getTitle().equals("To Kill a Mockingbird")));  // This one should be excluded as it is out of stock
    }
}
