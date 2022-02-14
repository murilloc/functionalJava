package com.lerning;

import java.util.function.BiFunction;
import java.util.function.Function;

public class PartialApplication {
    public static void main(String[] args) {

        TriFunction<Integer, Integer, Integer, Integer> add =
                (x, y, z) -> x + y + z;

        Function<Integer, BiFunction<Integer, Integer, Integer>> addPartial =
                (x) -> (y, z) -> add.apply(x, y, z);

        BiFunction<Integer, Integer, Integer> add5 = addPartial.apply(5);

        System.out.println(add5.apply(6, 7));

        // Passando dois argumentos e deixando o próximo para mais tarde
        BiFunction<Integer, Integer, Function<Integer, Integer>> addPartial2 =
                (x, y) -> (z) -> add.apply(x, y, z);

        Function<Integer, Integer> add5And6 = addPartial2.apply(5, 6);

        System.out.println(add5And6.apply(7));

        // Currying
        Function<Integer, Function<Integer, Function<Integer, Integer>>> addPartial3 =
                (x) -> (y) -> (z) -> add.apply(x, y, z);

        Function<Integer, Function<Integer,Integer>> add5_2 = addPartial3.apply(5);
        Function<Integer, Integer> add5And6_2 = add5_2.apply(6);
        Integer sum = add5And6_2.apply(7);

        System.out.println(sum);

        System.out.println(addPartial3);

    }
}
