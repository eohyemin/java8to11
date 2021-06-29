package com.example.java8to11.lambda;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Foo {
    public static void main(String[] args) {
        RunSomething runSomething1 = () -> System.out.println("RUN");

        // 입력 받은 값이 동일한 경우, 결과가 같아야 함
        ReturnSomething returnSomething = (num) -> num + 10;
        System.out.println(returnSomething.doIt(10));
        System.out.println(returnSomething.doIt(10));

        Supplier<Integer> get10 = () -> 10;
        BinaryOperator<Integer> sum = (a, b) -> a + b;
        // 컴파일러 타입 추론

        Foo foo = new Foo();
        foo.run();
    }

    private void run() {
        // 변수 캡쳐
        // effective final인 변수만 참조 가능
        final int baseNumber = 10;

        // 로컬 클래스
        class LocalClass {
            void printBaseNumber() {
                System.out.println(baseNumber);
            }
        }

        // 익명 클래스
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(baseNumber); // 쉐도잉
            }
        };

        // 람다
        Consumer<Integer> printInt = i -> System.out.println(i+baseNumber); // baseNumber와 같은 scope
        printInt.accept(10);

    }
}
