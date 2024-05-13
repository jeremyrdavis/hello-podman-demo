package io.arrogantprogrammer;

public class Greeting {

    String author;

    String greeting;

    public Greeting(String author, String greeting) {
        this.author = author;
        this.greeting = greeting;
    }

    public Greeting() {
    }

    public String getAuthor() {
        return author;
    }

    public String getGreeting() {
        return greeting;
    }
}
