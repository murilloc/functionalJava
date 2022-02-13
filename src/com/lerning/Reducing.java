package com.lerning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class Reducing {

    public static void main(String[] args) {

        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> listOfInteger = new ArrayList<>(Arrays.asList(intArray));

        BinaryOperator<Integer> getSum = (acc, x) -> {
            Integer result = acc + x;
            System.out.printf("Acc: %d ,x: %d, result: %d%n ", acc, x, result);
            return result;
        };


        Integer sum = listOfInteger
                .stream()
                .reduce(0, getSum);

        System.out.println(sum);
    }
}
