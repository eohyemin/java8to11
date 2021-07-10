package com.example.java8to11.lambda;

import java.util.function.*;

public class App {
    public static void main(String[] args) {
        // Function<T, R>
        // compose, andThen - 함수를 조합할 수 있는 default 메소드
        Plus plus = new Plus();
        System.out.println(plus.apply(11));

        Function<Integer, Integer> plus10 = (i) -> i+10;
        Function<Integer, Integer> multiply2 = (i) -> i*2;

        Function<Integer, Integer> multiply2AndPlus10 = plus10.compose(multiply2); // 입력값인 함수 multiply2 (고차함수) 먼저 적용 -> plus10 적용
        System.out.println(multiply2AndPlus10.apply(2));

        System.out.println(plus10.andThen(multiply2).apply(2));

        // Consumer<T>
        Consumer<Integer> printT = (i) -> System.out.println(i);
        printT.accept(10);

        // Supplier<T>
        Supplier<Integer> get10 = () -> 10;
        System.out.println(get10.get());

        // Predicate<T>
        // and, or, negate 함수 조합합
        Predicate<String> startsWithA = (s) -> s.startsWith("A");
        Predicate<Integer> isEven = (i) -> i%2 == 0;

    }
}
