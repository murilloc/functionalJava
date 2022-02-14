package com.lerning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParallelStreams {

    public static void main(String[] args) {
        String[] wordsArray = {"hello", "java", "functional", "programming", "is", "cool"};
        List<String> words = new ArrayList<>(Arrays.asList(wordsArray));

        List<String> processedWords = words
                .parallelStream()
                .map((word) -> {
                    System.out.printf("Uppercasing: %s%n", word);
                    return word.toUpperCase();
                })
                .map((word) -> {
                    System.out.printf("Adding exlcamation poit to %s%n", word);
                    return word + '!';
                })
                .toList();

        System.out.println(processedWords);

    }
}
