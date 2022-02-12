package com.lerning;

import java.util.function.Function;

public class FunctionInterface {

    protected static class MyMath {
        public static Integer triple(Integer x) {
            return x * 3;
        }
    }


    public static void main(String[] agrs) {
        Function<Integer, Integer> myTRiple = MyMath::triple;
        Integer result = myTRiple.apply(32);
        System.out.println(result);
    }
}
