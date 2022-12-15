package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book = new Book(12, "Jungle");
        Book book2 = new Book(102, "Happy");
        Book book3 = new Book(75, "Year");
        Book book4 = new Book(100, "Clean code");
        Book[] books = {book, book2, book3, book4};
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName() + " " + books[i].getCount());
        }
        Book bookTemp = books[3];
        books[3] = books[0];
        books[0] = bookTemp;
        System.out.println("Change books!");
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName() + " " + books[i].getCount());
        }
        System.out.println("Books with name \"Clean code\"");
        for (int i = 0; i < books.length; i++) {
            if ("Clean code".equals(books[i].getName())) {
                System.out.println(books[i].getName() + " " + books[i].getCount());
            }
        }
    }
}
