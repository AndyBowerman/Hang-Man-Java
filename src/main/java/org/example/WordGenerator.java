package org.example;

import java.util.ArrayList;
import java.util.Random;

public class WordGenerator {
    private final ArrayList<String> words = new ArrayList<String>();
    private static final Random randomNum = new Random();

    public WordGenerator() {
        words.add("hello");
        words.add("goodbye");
        words.add("book");
        words.add("glasses");
        words.add("plant");
        words.add("flower");
        words.add("apple");
        words.add("carrot");
        words.add("yellow");
        words.add("orange");
        words.add("potato");
        words.add("football");
        words.add("tennis");
        words.add("crocodile");
        words.add("penguin");
        words.add("window");
        words.add("television");
        words.add("wheel");
        words.add("caterpillar");
        words.add("rugby");
        words.add("scarf");
    }

    public String getRandomWord() {
        return words.get((randomNum.nextInt(words.size())));
    }
}
