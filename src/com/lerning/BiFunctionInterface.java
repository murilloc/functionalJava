package com.lerning;

import java.util.function.BiFunction;

public class BiFunctionInterface {

    public static void main(String[] args) {

        BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;

        System.out.println(add.apply(56, 77));

        TriFunction<Integer, Integer, Integer, Integer> addThree = (x, y, z) -> x + y + z;

        NoArgsFunction<String> getMyName = () -> "Murillo Cesar";

        System.out.println(addThree.apply(32, 65, 44));

        System.out.println(getMyName.apply());
    }


}
