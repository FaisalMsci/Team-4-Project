package com.example;

class Book{
    private String title, author_name, category, publisher;
    private double price;
    private int availability;

    // Parameterized Constructor;

    public Book(String title, String author_name, String category, String publisher, double price, int availability) {
        this.title = title;
        this.author_name = author_name;
        this.category = category;
        this.publisher = publisher;
        this.price = price;
        this.availability = availability;
    }

    /* Getter methods that provide encapsulation benefits; here, the individual attributes are not
    directly accessible other than by the Getter Methods */

    public String getTitle() {
        return title;
    }

    public String getAuthorName() {
        return author_name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getAvailability() {
        return availability;
    }

    // default toString() method is inherited from the Object class. While it usually returns info such as Classname@hashcode,
    // to provide meaningful results we changed it to return a string. Purpose of this class is nothing but to provide a human readable version of the object

    @Override
    public String toString() {
        return "Book\n{\n" +
                "\ttitle='" + title + "'\n" +
                "\tauthor_name='" + author_name + "'\n" +
                "\tcategory='" + category + "'\n" +
                "\tpublisher='" + publisher + "'" +
                "\n\tprice=" + price +
                "\n\tavailability=" + availability +
                "\n}\n\n";
    }
}