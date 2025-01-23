package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    private Book book;

    @BeforeEach
    void setUp() {
        // Initialize the Book object before each test
        book = new Book("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", "Scribner", 10.99, 100);
    }

    @Test
    void testBookConstructorAndGetters() {
        // Test that the constructor correctly initializes the object and getter methods return the right values
        assertEquals("The Great Gatsby", book.getTitle());
        assertEquals("F. Scott Fitzgerald", book.getAuthorName());
        assertEquals("Fiction", book.getCategory());
        assertEquals(10.99, book.getPrice());
        assertEquals(100, book.getAvailability());
    }

    @Test
    void testToString() {
        String expected = "Book\n{\n" +
                "\ttitle='The Great Gatsby'\n" +
                "\tauthor_name='F. Scott Fitzgerald'\n" +
                "\tcategory='Fiction'\n" +
                "\tpublisher='Scribner'\n" +
                "\tprice=10.99\n" +
                "\tavailability=100\n}\n\n";  
        assertEquals(expected, book.toString());
    }
    
}
