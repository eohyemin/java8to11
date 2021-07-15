package com.example.java8to11.optional;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
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

        OnlineClass spring_boot = new OnlineClass(1, "Spring Boot", true);
        Optional<Progress> progress = spring_boot.getProgress();
        progress.ifPresent(p-> System.out.println(p.getStudyDuration()));

        Optional<OnlineClass> optionalClass = springClasses.stream()
                .filter(oc->oc.getTitle().toLowerCase().startsWith("spring"))
                .findFirst();
        boolean present = optionalClass.isPresent();
        boolean empty = optionalClass.isEmpty();
        //OnlineClass onlineClass = optionalClass.get(); // NoSuchElementException
        System.out.println(present);
        System.out.println(empty);
        //System.out.println(onlineClass.getTitle());

        optionalClass.ifPresent(oc -> System.out.println(oc.getTitle()));

        OnlineClass onlineClass1 = optionalClass.orElse(createNewClass());
        System.out.println(onlineClass1.getTitle());

        OnlineClass onlineClass2 = optionalClass.orElseGet(App::createNewClass); // Supplier
        System.out.println(onlineClass2.getTitle());

        Optional<OnlineClass> onlineClass3 = optionalClass.filter(oc -> oc.getId()>10);
        System.out.println(onlineClass3.isEmpty());

        Optional<Integer> onlineClass4 = optionalClass.map(oc -> oc.getId());
        System.out.println(onlineClass4.isPresent());

        // map으로 꺼내는 type이 Optional이라면
        Optional<Progress> progress1 = optionalClass.flatMap(OnlineClass::getProgress);

    }

    private static OnlineClass createNewClass() {
        System.out.println("create new class");
        return new OnlineClass(10, "New class", false);
    }

}
