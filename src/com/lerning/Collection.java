package com.lerning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Collection {

    public static void main(String[] args) {
        String[] wordsArray = {"hello", "java", "functional", "programming", "is", "cool"};
        List<String> words = new ArrayList<>(Arrays.asList(wordsArray));

        String longWords = words
                .stream()
                .filter((word) -> word.length() > 5)
                .collect(Collectors.joining("|"));
        System.out.println(longWords);

        Long howManyLongWords = words
                .stream()
                .filter((word) -> word.length() > 5).count();
        System.out.println(howManyLongWords);


        Map<Integer, List<String>> groupingByMap = words
                .stream()
                .collect(Collectors.groupingBy((word) -> word.length()));

        System.out.println(groupingByMap);

        Map<Integer, List<String>> groupingByMap2 = words
                .stream()
                .collect(Collectors.groupingBy(String::length));

        System.out.println(groupingByMap2);

        Map<Boolean, List<String>> partitioningMap = words
                .stream()
                .collect(Collectors.groupingBy((word) -> word.length() > 5));

        System.out.println(partitioningMap);




    }
}
