package dk.via.json.book;

import java.util.Arrays;

public class Book {
    private final String title;
    private final int date;
    private final String publisher;
    private final Author[] authors;

    public Book(String title, int date, String publisher, Author... authors) {
        this.title = title;
        this.date = date;
        this.publisher = publisher;
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public int getDate() {
        return date;
    }

    public String getPublisher() {
        return publisher;
    }

    public Author[] getAuthors() {
        return authors;
    }

    @Override
    public String toString() {
        return "Book(" +
                "title:'" + title + '\'' +
                ", date:" + date +
                ", publisher:'" + publisher + '\'' +
                ", authors:" + Arrays.toString(authors) +
                ')';
    }
}
