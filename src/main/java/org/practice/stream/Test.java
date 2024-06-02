package org.practice.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        //useMap();
        //useFilter();
        //useSorted();
        //useForEach();
        useReduce();
    }

    private static void useMap(){
        List<Integer> numbers = Arrays.asList(2,3,4,5);
        List<Integer> square = numbers.stream().map(n -> n * n).collect(Collectors.toList());
        printNumList(square);
    }

    private static void useFilter(){
        List<String> names = Arrays.asList("Reflection","Collection","Stream");
        List<String> result = names.stream().filter(s -> s.endsWith("ion")).collect(Collectors.toList());
        printStringList(result);
    }

    private static void useForEach(){
        List<Integer> numbers = Arrays.asList(2,3,4,5);
        numbers.stream().map(n -> n * n).forEach(System.out::println);
    }

    private static void useReduce(){
        List<Integer> number = Arrays.asList(2,3,4,8);
        int sum = number.stream().filter(x->x%2==0).reduce(0, Integer::sum);
        //int sum = number.stream().filter(x -> x < 5).reduce(0, Integer::sum);
        System.out.println(sum);
    }

    private static void useSorted(){
        List<Integer> numbers = Arrays.asList(40,80,60,10,50);
        List<Integer> result = numbers.stream().sorted().collect(Collectors.toList());
        printNumList(result);
    }

    private static void printNumList(List<Integer> list){
        for (int num : list){
            System.out.print(num + " ");
        }
        System.out.println();
    }

    private static void printStringList(List<String> list){
        for (String str : list){
            System.out.print(str + " ");
        }
        System.out.println();
    }
}
