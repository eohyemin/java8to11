package com.example.java8to11.methodreference;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class App {
    public static void main(String[] args) {
        UnaryOperator<String> hi = Greeting::hi;

        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello; // 메소드를 참조하도록 만든 것

        Supplier<Greeting> newGreeting = Greeting::new;

        // 문자열 한개 -> Greeting
        Function<String, Greeting> greetingFunction = Greeting::new;
        Greeting hyemin = greetingFunction.apply("hyemin");
        System.out.println(hyemin.getName());

        String[] abc = {"c", "b", "a"};
        Arrays.sort(abc, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(abc));
    }
}
