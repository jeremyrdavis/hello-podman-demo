package io.arrogantprogrammer;

public class Greeting {

    String author;

    String text;

    public Greeting(String author, String text) {
        this.author = author;
        this.text = text;
    }

    public Greeting() {
    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }
}
