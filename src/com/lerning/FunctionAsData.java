package com.lerning;

public class FunctionAsData {

    protected static class Person {
        private String name;
        private Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }

    protected static class DataLoader {

        public final NoArgsFunction<Person> loadPerson;

        public DataLoader(Boolean isDevelopment) {
            this.loadPerson = isDevelopment ? this::loadPersonFake : this::loadPersonReal;
        }

        private Person loadPersonReal() {
            System.out.println("Loading person");
            return new Person("Real person", 55);
        }

        private Person loadPersonFake() {
            System.out.println("Resturning fake person object...");
            return new Person(" Fake person", 100);
        }
    }

    public static void main(String[] args) {

        final Boolean IS_DEVELOPMENT = false;

        DataLoader dataLoader = new DataLoader(IS_DEVELOPMENT);
        System.out.println(dataLoader.loadPerson.apply());

    }
}
