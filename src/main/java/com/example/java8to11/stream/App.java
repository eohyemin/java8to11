package com.example.java8to11.stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "Spring Boot", true));
        springClasses.add(new OnlineClass(2, "Spring Data JPA", true));
        springClasses.add(new OnlineClass(3, "Spring mvc", false));
        springClasses.add(new OnlineClass(4, "Spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        System.out.println("[Spring 으로 시작하는 수업]");
        // TODO
        springClasses.stream()
                .filter(c->c.getTitle().toLowerCase().startsWith("spring"))
                .forEach(System.out::println);

        System.out.println("[closed 되지 않은 수업]");
        // TODO
        springClasses.stream()
                .filter(c->!c.isClosed())
                .forEach(System.out::println);

        springClasses.stream()
                .filter(Predicate.not(OnlineClass::isClosed))
                .forEach(System.out::println);

        System.out.println("[수업 이름만 모아서 스트림 만들기]");
        // TODO
        springClasses.stream()
                .map(OnlineClass::getTitle)
                .forEach(System.out::println);


        List<OnlineClass> javaClassed = new ArrayList<>();
        javaClassed.add(new OnlineClass(6, "The Java, Test", true));
        javaClassed.add(new OnlineClass(7, "The Java, Code", true));
        javaClassed.add(new OnlineClass(8, "The Java, 8 to 11", false));

        List<List<OnlineClass>> events = new ArrayList<>();
        events.add(springClasses);
        events.add(javaClassed);

        System.out.println("[두 수업 목록에 들어 있는 모든 수업 아이디 출력]");
        // TODO
        events.stream().flatMap(Collection::stream)
                .forEach(c->System.out.println(c.getId()));

        System.out.println("[10부터 1씩 증가하는 무제한 스트림 중에서, 앞에 10개 빼고 최대 10개 까지만]");
        // TODO
        Stream.iterate(10, i -> i+1)
                .skip(10)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("[Java 수업 중 Test가 들어있는 수업이 있는지 확인]");
        // TODO
        boolean bool = javaClassed.stream()
                .anyMatch(c -> c.getTitle().toLowerCase().contains("test"));
        System.out.println(bool);

        System.out.println("[Spring 수업 중 제목에 Spring이 들어간 것만 모아서 List로 만들기]");
        // TODO
        List<OnlineClass> springFilterClasses = springClasses.stream()
                .filter(c->c.getTitle().toLowerCase().contains("spring"))
                .collect(Collectors.toList());

        springFilterClasses.stream()
                .forEach(System.out::println);

    }

}
