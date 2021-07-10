package com.example.java8to11.lambda;

import java.util.function.Function;

public class Plus implements Function<Integer, Integer> {

    @Override
    public Integer apply(Integer integer) {
        return integer + 10;
    }

}
