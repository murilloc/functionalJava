package com.lerning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Mapping {

    public static void main(String[] args) {

        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> listOfInteger = new ArrayList<>(Arrays.asList(intArray));

        // procedural Way
        List<Integer> doubled = new ArrayList<>();
        for (Integer integer : listOfInteger) {
            Integer result = integer * 2;
            doubled.add(result);
        }
        System.out.println(doubled);

        // functional way
        Function<Integer, Integer> timesTwo = (x) -> x * 2;
        List<Integer> doubledList = listOfInteger
                .stream()
                .map(timesTwo)
                .collect(Collectors.toList());

        System.out.println(doubledList);


    }


}
