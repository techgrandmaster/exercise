package com.exercise.classwork;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

public class Exercise2 {

    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        List<Integer> numbersList = Arrays.asList(numbers);

        System.out.println("Even numbers in the range 1 to 20 (inclusive) ------------------------");
        Predicate<Integer> evenNumberPredicate = x -> x % 2 == 0;
        numbersList.stream().filter(evenNumberPredicate).forEach(System.out::println);
        System.out.println();

        System.out.println("Sum of all odd numbers in the range 1 to 20 --------------------------");
        Predicate<Integer> oddNumberPredicate = x -> x % 2 != 0;
        int sum = numbersList.stream().filter(oddNumberPredicate).reduce(0, Integer::sum);
//        int sum = numbersList.stream().filter(oddNumberPredicate).mapToInt(Integer::intValue).sum();
        System.out.println(sum);
        System.out.println();

        System.out.println("List of even numbers in the range 1 to 20 (inclusive) ----------------");
        List<Integer> evenNumbers = numbersList.stream().filter(evenNumberPredicate).collect(toList());
//        List<Integer> evenNumbers = numbersList.stream().filter(evenNumberPredicate).toList();
        System.out.println(evenNumbers);
        System.out.println();

        System.out.println("List of square of even numbers in the range 1 to 20 (inclusive) ------");
        Function<Integer, Integer> squareFunction = y -> y * y;
        Function<List<Integer>, List<Integer>> squareNumbersFunction = x -> x.stream().map(squareFunction).collect(toList());
        System.out.println(squareNumbersFunction.apply(evenNumbers));
//        List<Integer> squareOfEvenNumbers = numbersList.stream().filter(evenNumberPredicate).map(squareFunction).toList();
//        System.out.println(squareOfEvenNumbers);
    }
}
