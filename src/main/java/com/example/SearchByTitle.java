package com.example;

import java.util.List;
import java.util.stream.Collectors;

// Strategy for searching by title
class SearchByTitle implements SearchStrategy {
    public List<Book> search(String title, List<Book> books) {
        return books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase()) && book.getAvailability() > 0)
                .collect(Collectors.toList());
    }
}
