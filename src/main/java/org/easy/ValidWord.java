package org.easy;

import java.util.Objects;
import java.util.Scanner;

class ValidWord {
    public boolean isValid(String word) {
        // Check if the word contains a minimum of 3 characters.
        if (word == null || word.length() < 3) return false;
        // Check if the word contains only alphanumeric characters.
        if (!word.matches("[a-zA-Z0-9]+")) return false;

        boolean hasVowel = false;
        boolean hasConsonant = false;
        // Check if the word contains at least one vowel and one consonant.
        for (char c : word.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(c) >= 0) {
                hasVowel = true;
            } else if (Character.isLetter(c)) {
                hasConsonant = true;
            }
        }
        return hasConsonant && hasVowel;
    }
    public static void main(String[] args) {
        ValidWord solution = new ValidWord();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a word to check if it is valid (type 'Stop' to exit):");
        String word = scanner.next();
        while(!Objects.equals(word, "Stop")) {
            boolean result = solution.isValid(word);
            System.out.println("Is the word: " + word + " valid? " + result);
            word = scanner.next();
        }
    }
}