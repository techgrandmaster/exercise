package com.exercise.classwork;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

public class Exercise1 {

    public static void main(String[] args) {
        String[] names = {"Mary", "Maryam", "Mitchell", "Mimi", "Margaret", "Emily", "Monster"};
        List<String> namesList = Arrays.asList(names);

        System.out.println("Five characters and below ====================================");
        Predicate<String> fiveCharactersAndBelow = name -> name.length() <= 5;
        namesList.stream().filter(fiveCharactersAndBelow).forEach(System.out::println);
        System.out.println();

        System.out.println("To upper case ================================================");
        Function<String, String> upperCase = String::toUpperCase;
//        Function<String, String> upperCase = name -> name.toUpperCase();
        namesList.stream().map(upperCase).forEach(System.out::println);
        System.out.println();

        System.out.println("Starts with 'Ma'==============================================");
        Predicate<String> startsWithMa = name -> name.startsWith("Ma");
        List<String> startsWithMaList = namesList.stream().filter(startsWithMa).collect(toList());
        System.out.println(startsWithMaList);
        System.out.println();

        System.out.println("Sort in descending order =====================================");
        Comparator<String> nameComparator = Comparator.reverseOrder();
//        Comparator<String> nameComparator = (o1, o2) -> o2.compareTo(o1);
        List<String> descendingOrder = namesList.stream().sorted(nameComparator).collect(toList());
        System.out.println(descendingOrder);
    }
}
