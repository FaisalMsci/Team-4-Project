package com.example;

import java.util.List;

class SearchService {
    private SearchStrategy strategy;

    // No-argument constructor
    public SearchService() {
        // Nothing to initialize here for now
    }

    public void setSearchStrategy(SearchStrategy strategy) {
        this.strategy = strategy;
    }

    public List<Book> performSearch(String query, List<Book> books) {
        return strategy.search(query, books);
    }
}