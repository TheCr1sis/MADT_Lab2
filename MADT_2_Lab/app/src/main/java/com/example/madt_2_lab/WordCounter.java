package com.example.madt_2_lab;

public class WordCounter {
    public static int countWords(String text)
    {
        String[] words = text.split("[\\s,\\.]+");

        return words.length;
    }

    public static int countCharacters(String text)
    {
        return text.length();
    }
}
