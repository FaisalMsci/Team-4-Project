package com.example;

import java.util.List;
import java.util.stream.Collectors;

class SearchByAuthor implements SearchStrategy {
    public List<Book> search(String authorName, List<Book> books) {
        return books.stream()
                .filter(book -> book.getAuthorName().equalsIgnoreCase(authorName) && book.getAvailability() > 0)
                .collect(Collectors.toList());
    }
}
