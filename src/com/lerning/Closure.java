package com.lerning;

public class Closure {

    public static void main(String[] args) {
        NoArgsFunction<NoArgsFunction<String>> createGreeter = () -> {
            String name = "Murillo";
            return () -> String.format("Hello, %s!", name);
        };

        NoArgsFunction<String> greeter = createGreeter.apply();
        System.out.println(greeter.apply());
    }

}
