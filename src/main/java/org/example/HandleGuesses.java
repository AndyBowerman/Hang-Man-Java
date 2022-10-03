package org.example;

import java.util.ArrayList;

public class HandleGuesses {
    private ArrayList<String> guessedLetters = new ArrayList<>();

    public ArrayList<String> getGuessedLetters() {
        return guessedLetters;
    }

    public void addToLetters(String letter) {
        guessedLetters.add(letter);
    }

    public String checkGuess(String selectedWord) {
        StringBuilder output = new StringBuilder();
        String[] splitSelectedWord = selectedWord.split("");
        for (String s : splitSelectedWord) {
            if (guessedLetters.contains(s)) {
                output.append(s);
            } else {
                output.append("_");
            }
        }
        return output.toString();
    }
}
