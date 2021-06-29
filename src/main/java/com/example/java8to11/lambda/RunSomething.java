package com.example.java8to11.lambda;

@FunctionalInterface
public interface RunSomething {
    void doIt(); // 추상 메소드가 1개
    static void printName() {
        System.out.println("RUN");
    }
    default void printHello() {
        System.out.println("HELLO");
    }
}
