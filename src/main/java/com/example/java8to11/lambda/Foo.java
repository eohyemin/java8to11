package com.example.java8to11.lambda;

public class Foo {
    public static void main(String[] args) {
        RunSomething runSomething = new RunSomething() {
            @Override
            public void doIt() {
                System.out.println("RUN");
            }
        };
        RunSomething runSomething1 = () -> System.out.println("RUN");

        ReturnSomething returnSomething = (num) -> num + 10;
        System.out.println(returnSomething.doIt(10));
        System.out.println(returnSomething.doIt(10));

        int baseNumber = 100;
        ReturnSomething returnSomething1 = num -> num + baseNumber;
    }
}
