package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();

        // Adding books to the collection (Same as before)
        books.add(new Book("Effective Java", "Joshua Bloch", "Programming", "Addison-Wesley", 45.99, 10));
        books.add(new Book("Clean Code", "Robert C. Martin", "Programming", "Prentice Hall", 42.99, 0));
        books.add(new Book("The Pragmatic Programmer", "Andrew Hunt", "Programming", "Addison-Wesley", 39.99, -1));
        books.add(new Book("Head First Java", "Kathy Sierra", "Programming", "O'Reilly Media", 35.99, 12));
        books.add(new Book("Design Patterns", "Erich Gamma", "Programming", "Addison-Wesley", 47.99, 7));

        books.add(new Book("To Kill a Mockingbird", "Harper Lee", "Fiction", "J.B. Lippincott & Co.", 10.99, 25));
        books.add(new Book("1984", "George Orwell", "Fiction", "Secker & Warburg", 8.99, 30));
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", "Charles Scribner's Sons", 9.99, 20));
        books.add(new Book("Pride and Prejudice", "Jane Austen", "Fiction", "T. Egerton", 8.99, 18));
        books.add(new Book("Moby Dick", "Herman Melville", "Fiction", "Harper & Brothers", 11.99, 12));

        books.add(new Book("Batman: Year One", "Frank Miller", "Comics", "DC Comics", 15.99, 10));
        books.add(new Book("Spider-Man: Blue", "Jeph Loeb", "Comics", "Marvel Comics", 13.99, 0));
        books.add(new Book("Watchmen", "Alan Moore", "Comics", "Comics", 18.99, 15));
        books.add(new Book("The Sandman: Preludes & Nocturnes", "Neil Gaiman", "Comics", "Vertigo", 20.99, -200));
        books.add(new Book("X-Men: Dark Phoenix Saga", "Chris Claremont", "Comics", "Marvel Comics", 14.99, 8));

        books.add(new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "Fantasy", "Scholastic", 12.99, 50));
        books.add(new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", "George Allen & Unwin", 10.99, 40));
        books.add(new Book("A Game of Thrones", "George R.R. Martin", "Fantasy", "Bantam Spectra", 15.99, -1));
        books.add(new Book("The Name of the Wind", "Patrick Rothfuss", "Fantasy", "DAW Books", 13.99, 22));
        books.add(new Book("Mistborn: The Final Empire", "Brandon Sanderson", "Fantasy", "Tor Books", 12.99, 25));

        SearchService searchService = new SearchService();
        
        // User input for search criteria
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select search strategy (1: By Author, 2: By Title, 3: By Category): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline character
        
        System.out.println("Enter the search query (e.g. Author name, Title, or Category): ");
        String query = scanner.nextLine();

        // Switch case to handle search strategy selection
        switch (choice) {
            case 1:
                searchService.setSearchStrategy(new SearchByAuthor());
                System.out.println("\nSearching by Author: " + query);
                break;
            case 2:
                searchService.setSearchStrategy(new SearchByTitle());
                System.out.println("\nSearching by Title: " + query);
                break;
            case 3:
                searchService.setSearchStrategy(new SearchByCategory());
                System.out.println("\nSearching by Category: " + query);
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }

        // Perform the search and print results
        List<Book> results = searchService.performSearch(query, books);
        if (results.isEmpty()) {
            System.out.println("No books found matching the query.");
        } else {
            results.forEach(System.out::println);
        }
    }
}
