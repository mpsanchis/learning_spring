package ch4abstractions.models;

public class Comment {
    private String text;
    private String author;

    public Comment(String author, String text) {
        this.author = author;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "{text: " + this.text + ", "
                + "author: " + this.author
                + "}";
    }
}
