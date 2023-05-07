package edu.guilford;

    // Class to hold each word and its number of occurrences
    public class WordCount implements Comparable<WordCount> {
        String word;
        int count;

        // Constructor  
        public WordCount(String word, int count) {
            this.word = word;
            this.count = count;
        }

        //getters and setters
        public String getWord() {
            return word;
        }
        
        public void setWord(String word) {
            this.word = word;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        
        
        // Sort by count in descending order
        @Override
        public int compareTo(WordCount other) {
            return Integer.compare(other.count, count);
        }
    }
