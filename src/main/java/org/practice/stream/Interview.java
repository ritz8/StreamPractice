package org.practice.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Interview {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4,5,6,7,1,2,3);
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15,112);
        String input = "My mellow are spicy";
        String str = "string data to count each character";
        int[] arr = { 99, 55, 203, 99, 4, 91 };
        List<String> strList = Arrays.asList("Collection", "Reflection", "Stream");
        List<String> names = Arrays.asList("AA", "BB", "AA", "CC");

        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("=================================== Display Menu ===================================");
            System.out.println("1 -> Find even number from the list using Stream API");
            System.out.println("2 -> Find digits starts with 1 from the list using Stream API");
            System.out.println("3 -> Find duplicate elements from the list using Stream API");
            System.out.println("4 -> Find first element from the list using Stream API");
            System.out.println("5 -> Count the odd elements from the list using Stream API");
            System.out.println("6 -> Find largest element from the list using Stream API");
            System.out.println("7 -> Find the first non-repeated character in a String using Stream API");
            System.out.println("8 -> Find the first repeated character in a String using Stream API");
            System.out.println("9 -> Sort all the values present in a list using Stream API");
            System.out.println("10 -> Sort all the values present in a list in descending order using Stream API");
            System.out.println("11 -> Perform cube on list elements and filter numbers greater than 50 using Stream API");
            System.out.println("12 -> Sort an array and then convert the sorted array into Stream using Stream API");
            System.out.println("13 -> Convert object into Uppercase using Stream API");
            System.out.println("14 -> Count each element/word from the list using Stream API");
            System.out.println("15 -> Duplicate elements with its count from list using Stream API");
            System.out.println("16 -> Print the count of each character in a String using Stream API");
            System.out.println("17 -> Exit");
            System.out.println("====================================================================================");
            System.out.println("Enter your choice : ");
            option = scanner.nextInt();
            switch (option) {
                case 1 -> findEven(list);
                case 2 -> findDigitsStartsWithOne(myList);
                case 3 -> findDuplicate(myList);
                case 4 -> findFirst(myList);
                case 5 -> oddCount(myList);
                case 6 -> findMax(myList);
                case 7 -> findFirstNonRepeatedCharacter(input);
                case 8 -> firstRepeatedCharacter(input);
                case 9 -> sortElements(myList);
                case 10 -> sortDescending(myList);
                case 11 -> findGreaterThan50InCubicList(list);
                case 12 -> sortArray(arr);
                case 13 -> convertUpper(strList);
                case 14 -> wordCount(names);
                case 15 -> duplicateCount(names);
                case 16 -> countCharacter(str);
                case 23 -> System.out.println("Exiting...");
                default -> System.out.println("Please select the valid option");
            }
        } while (option != 17);
        scanner.close();
    }

    private static void findEven(List<Integer> list){
        list.forEach(n -> System.out.print(n + " "));
        System.out.println();
        list.stream().filter(n -> n % 2 == 0).forEach(System.out::println);
    }

    private static void findDigitsStartsWithOne(List<Integer> list){
        list.forEach(n -> System.out.print(n + " "));
        System.out.println();
        list.stream().map(String::valueOf).filter(s -> s.startsWith("1")).forEach(System.out::println);
    }

    private static void findDuplicate(List<Integer> list){
        list.forEach(n -> System.out.print(n + " "));
        System.out.println();
        Set<Integer> set = new HashSet<>();
        list.stream().filter(n -> !set.add(n)).forEach(System.out::println);
    }

    private static void findFirst(List<Integer> list){
        list.forEach(n -> System.out.print(n + " "));
        System.out.println();
        list.stream().findFirst().ifPresent(System.out::println);
    }

    private static void oddCount(List<Integer> list){
        list.forEach(n -> System.out.print(n + " "));
        System.out.println();
        long count = list.stream().filter(x -> x % 2 != 0).count();
        System.out.println(count);
    }

    private static void findMax(List<Integer> list){
        list.forEach(n -> System.out.print(n + " "));
        System.out.println();
        list.stream().max(Integer::compare).ifPresent(System.out::println);
    }

    private static void findFirstNonRepeatedCharacter(String str){
        System.out.println(str);
        str.chars()
                .mapToObj(s -> Character.toLowerCase((char) s))
                .collect(Collectors.groupingBy(
                        Function.identity(), LinkedHashMap:: new, Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() == 1L)
                .map(Map.Entry::getKey).findFirst().ifPresent(System.out::println);
    }

    private static void firstRepeatedCharacter(String str){
        System.out.println(str);
        str.chars()
                .mapToObj(s -> Character.toLowerCase((char) s))
                .collect(Collectors.groupingBy(
                        Function.identity(), LinkedHashMap::new, Collectors.counting()
                )).entrySet().stream().filter(entry -> entry.getValue() > 1L)
                .map(Map.Entry::getKey).findFirst().ifPresent(System.out::println);
    }

    private static void sortElements(List<Integer> list){
        list.forEach(n -> System.out.print(n + " "));
        System.out.println();
        list.stream().sorted().forEach(n -> System.out.print(n + " "));
        System.out.println();
    }

    private static void sortDescending(List<Integer> list){
        list.forEach(n -> System.out.print(n + " "));
        System.out.println();
        list.stream().sorted(Collections.reverseOrder()).forEach(n -> System.out.print(n + " "));
        System.out.println();
    }

    private static void findGreaterThan50InCubicList(List<Integer> list){
        list.forEach(n -> System.out.print(n + " "));
        System.out.println();
        list.stream().map(n -> n * n * n).filter(n -> n > 50).forEach(n -> System.out.print(n + " "));
        System.out.println();
    }

    private static void sortArray(int[] arr){
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
        Arrays.parallelSort(arr);
        Arrays.stream(arr).forEach(n -> System.out.print(n + " "));
        System.out.println();
    }

    private static void convertUpper(List<String> list){
        list.forEach(n -> System.out.print(n + " "));
        System.out.println();
        list.stream().map(String::toUpperCase).forEach(n -> System.out.print(n + " "));
        System.out.println();
    }

    private static void wordCount(List<String> list){
        list.forEach(n -> System.out.print(n + " "));
        System.out.println();
        list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((k, v) -> System.out.print(k + "-" + v + " "));
        System.out.println();
    }

    private static void duplicateCount(List<String> list) {
        list.forEach(n -> System.out.print(n + " "));
        System.out.println();
        list.stream().filter(s -> Collections.frequency(list, s) > 1)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((k, v) -> System.out.print(k + "-" + v + " "));
        System.out.println();
    }
    private static void countCharacter(String str){
        System.out.println(str);
        Arrays.stream(str.split("")).map(String::toLowerCase).filter(c -> ! c.equals(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((k, v) -> System.out.print(k + "-" + v + " "));
        System.out.println();
    }
}
