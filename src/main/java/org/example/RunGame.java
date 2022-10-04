package org.example;

import java.util.Scanner;

public class RunGame {
    private String selectedWord;
    private String hiddenWord;
    WordGenerator wordGenerator = new WordGenerator();
    HandleGuesses handleGuesses = new HandleGuesses();
    HandleLives handleLives = new HandleLives(5);
    Scanner scanner = new Scanner(System.in);

    public RunGame() {
        this.selectedWord = wordGenerator.getRandomWord();
        this.hiddenWord = handleGuesses.checkGuess(selectedWord);
    }

    public WordGenerator getWordGenerator() {
        return wordGenerator;
    }

    public void startGame() {
        System.out.println("Here's your word " + hiddenWord);
        System.out.println("So far you've guessed: " + handleGuesses.getGuessedLetters());
        System.out.println("Remaining lives: " + handleLives.getLives());
        System.out.println("What's your next guess?");
    }

    public void handleGuess(String guess) {
        if(guess.length() != 1){
            System.out.println("Please enter one letter at a time");
        } else if(selectedWord.contains(guess)) {
            System.out.println("Correct!");
            handleGuesses.addToLetters(guess);
            hiddenWord = handleGuesses.checkGuess(selectedWord);
        } else {
            System.out.println("Wrong!");
            handleGuesses.addToLetters(guess);
            handleLives.reduceLives();
        }
        playHangMan();
    }

    public void playHangMan() {
        String guess = "";
        if(hiddenWord.contains("_") && handleLives.getLives() > 0) {
            startGame();
            guess = scanner.nextLine().toLowerCase();
            handleGuess(guess);
        } else if(handleLives.getLives() == 0) {
            System.out.println("Dead!");
        } else {
            System.out.println("You win!");
        }
    }
}

