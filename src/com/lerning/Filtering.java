package com.lerning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Filtering {
    public static void main(String[] args) {

        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> listOfInteger = new ArrayList<>(Arrays.asList(intArray));

        String[] wordsArray = {"hello", "functional", "programming", "is", "cool"};
        List<String> words = new ArrayList<>(Arrays.asList(wordsArray));

        // Procedural way
        List<Integer> evens = new ArrayList<>();
        for (int number : listOfInteger) {
            boolean isEven = number % 2 == 0;
            if (isEven) evens.add(number);
        }
        System.out.println(evens);


        // Functional way
        Predicate<Integer> isEven = (x) -> x % 2 == 0;
        List<Integer> evensList = listOfInteger
                .stream()
                .filter(isEven)
                .collect(Collectors.toList());
        System.out.println(evensList);

        List<Integer> evensList2 = listOfInteger
                .stream()
                .filter((x) -> x % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(evensList2);

        Predicate<String> isLongerThanFive = (str) -> str.length() > 5;
        List<String> longWords = words
                .stream()
                .filter(isLongerThanFive)
                .collect(Collectors.toList());
        System.out.println(longWords);


        Function<Integer, Predicate<String>> createLengthTest = (minLength) -> {
            return (str) -> str.length() > minLength;
        };
        Predicate<String> isLongerThanThree = createLengthTest.apply(3);

        List<String> longWords2 = words
                .stream()
                .filter(isLongerThanThree)
                .collect(Collectors.toList());
        System.out.println(longWords2);

        List<String> longWords3 = words
                .stream()
                .filter(createLengthTest.apply(10))
                .collect(Collectors.toList());
        System.out.println(longWords3);


    }
}
