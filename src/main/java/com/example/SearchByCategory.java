package com.example;

import java.util.List;
import java.util.stream.Collectors;

// Strategy for searching by category
class SearchByCategory implements SearchStrategy {
    public List<Book> search(String category, List<Book> books) {
        return books.stream()
                .filter(book -> book.getCategory().equalsIgnoreCase(category) && book.getAvailability() > 0)
                .collect(Collectors.toList());
    }
}