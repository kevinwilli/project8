package edu.guilford;

import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) throws IOException {
        // Read the text file into a list of words
        try {
            // Read the text file into a list of words
            List<String> words = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(
                    "C:/Users/Utilisateur/OneDrive/Bureau/CTIS310/GitHub/project8/src/main/resources/myTextFile.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    for (String word : line.split("//W+")) { // Split on non-word characters
                        if (!word.matches("//d+")) { // Ignore words that are just digits
                            words.add(word.toLowerCase()); // Convert to lowercase
                        }
                    }
                }

            }

            // Sort the list of words alphabetically
            Collections.sort(words);

            // Write the list of words to a file
            try (PrintWriter writer = new PrintWriter(new FileWriter(
                    "C:/Users/Utilisateur/OneDrive/Bureau/CTIS310/GitHub/project8/src/main/resources/wordList.txt"))) {
                for (String word : words) {
                    writer.println(word);
                }
            }

            // Create a map of word counts
            Map<String, Integer> counts = new HashMap<>();
            for (String word : words) {
                counts.put(word, counts.getOrDefault(word, 0) + 1);
            }

            // Create a list of WordCount objects and sort by count
            List<WordCount> wordCounts = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : counts.entrySet()) {
                wordCounts.add(new WordCount(entry.getKey(), entry.getValue()));
            }
            Collections.sort(wordCounts);

            // // Write the list of word counts to a file
            // try (PrintWriter writer = new PrintWriter(new
            // FileWriter("resources/wordCounts.txt"))) {
            // for (WordCount wc : wordCounts) {
            // writer.println(wc.word + " " + wc.count);
            // }
            // }

            // Prompt the user for a word and report the number of occurrences
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a word to search for: ");

            // Add code to read the user's input and report the number of occurrences of the
            // word*
            String searchWord = scanner.next().toLowerCase();
            int searchCount = counts.getOrDefault(searchWord, 0);
            System.out.println(searchWord + " occurs " + searchCount + " times.");

            // // Prompt the user for a word and report the number of occurrences
            // Scanner scanner = new Scanner(System.in);
            // System.out.print("Enter a word to search for: ");
            //
            // //Add code to read the user's input and report the number of occurrences of
            // the word*

            // String searchWord = scanner.next().toLowerCase();
            // int searchCount = counts.getOrDefault(searchWord, 0);
            // System.out.println(searchWord + " occurs " + searchCount + " times.");
            // create a new list from words with no duplicates words
            List<String> uniqueWords = new ArrayList<>();
            for (String word : words) {
                if (!uniqueWords.contains(word)) {
                    uniqueWords.add(word);
                }
            }
            // Write the list of unique words to a file
            try (PrintWriter writer = new PrintWriter(new FileWriter(
                    "C:/Users/Utilisateur/OneDrive/Bureau/CTIS310/GitHub/project8/src/main/resources/uniqueWords.txt"))) {
                for (String word : uniqueWords) {
                    writer.println(uniqueWords);
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading or writing the file: " + e.getMessage());
        }

    }
}
