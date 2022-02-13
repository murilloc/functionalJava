package com.lerning;

import java.util.function.Function;

public class ReturningFunctions {


    protected static class MyMath {
        public static Integer timesTwo(Integer x) {
            return x * 2;
        }

        public static Integer timesThree(Integer x) {
            return x * 3;
        }

        public static Integer timesFour(Integer x) {
            return x * 4;
        }

        // Replacing repetitive code
        public static Function<Integer, Integer> createMultiplier(Integer y) {
            return (Integer x) -> x * y;
        }


    }

    public static void main(String[] args) {
        NoArgsFunction<NoArgsFunction<String>> createGreeter = () -> () -> "Hello functional programming";
        NoArgsFunction<String> greeter = createGreeter.apply();
        System.out.println(greeter.apply());

        Function<Integer, Integer> timesTwo = MyMath.createMultiplier(2);
        Function<Integer, Integer> timesThree = MyMath.createMultiplier(3);
        Function<Integer, Integer> timesFive = MyMath.createMultiplier(5);

        System.out.println(timesFive.apply(6));
        System.out.println(timesThree.apply(44));
        System.out.println(timesTwo.apply(12));

    }
}
