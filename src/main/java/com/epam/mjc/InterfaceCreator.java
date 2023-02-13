package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InterfaceCreator {

    public static void main(String[] args) {

        InterfaceCreator creator = new InterfaceCreator();


        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            integers.add(i);
        }
        creator.addEvenValuesAtTheEnd().accept(integers);
    }

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return strings -> strings.stream().allMatch(e -> Character.isUpperCase(e.charAt(0)));
//        throw new UnsupportedOperationException("You should implement this method.");
    }


    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            List<Integer> list = new ArrayList<>();
            for (Integer i : x) {
                if (i % 2 == 0) {
                    list.add(i);
                }
            }
            x.addAll(list);
        };
//        throw new UnsupportedOperationException("You should implement this method.");
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            System.out.println(values);
            List<String> collect = values.stream()
                    .filter(e -> Character.isUpperCase(e.charAt(0)))
                    .filter(e -> e.endsWith("."))
                    .filter(e -> e.split(" ").length > 3)
                    .collect(Collectors.toList());
            System.out.println(collect);
            return collect;
        };

//        throw new UnsupportedOperationException("You should implement this method.");
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            Map<String, Integer> data = new HashMap<>();
            for (String s :
                    x) {
                data.put(s, s.length());
            }
            return data;
        };
//        throw new UnsupportedOperationException("You should implement this method.");
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            List<Integer> data = new ArrayList<>();
            data.addAll(list1);
            data.addAll(list2);
            return data;
        };
//        throw new UnsupportedOperationException("You should implement this method.");
    }


}
