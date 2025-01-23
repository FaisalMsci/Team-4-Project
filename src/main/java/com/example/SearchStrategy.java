package com.example;

import java.util.List;

interface SearchStrategy {
    List<Book> search(String query, List<Book> books);
}
