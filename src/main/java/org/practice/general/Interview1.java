package org.practice.general;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Interview1 {
    /*
    Write a java function
which excepts an arraylist as input parameter and returns an arraylist
input list -    20,30,40,50,20,10,50
output list-    20,50
     */
    public static void main(String[] args) {
        //oddSquare();
        //addDuplicateItems();
        int[] nums = {1,1,2};
        int k = removeDuplicates(nums);
        System.out.println(k);
    }

    private static void oddSquare() {
        List<Integer> list = Arrays.asList(2,3,4,5);
        list.stream().filter(i -> (i % 2 != 0) ).map(i -> i*i).forEach(System.out::println);
    }

    private static void addDuplicateItems() {
        List<Integer> input = Arrays.asList(20,30,40,50,20,10,50);
        List<Integer> output = new ArrayList<>();
        output = input.stream().distinct().collect(Collectors.toList());
        Map<Integer, Integer> count = new HashMap<>();
        for (int num: input) {
            count.put(num, count.getOrDefault(num, 0) + 1);
            if (count.get(num) > 1)
                output.add(num);
        }

        System.out.println(output);
    }

    private static int removeDuplicates(int[] nums) {
        List<Integer> list = IntStream.of(nums).boxed().toList();
        list = list.stream().distinct().collect(Collectors.toList());
        for (int i =0; i< list.size(); i++) {
            nums[i] = list.get(i);
        }

        for (int i =0; i< nums.length; i++) {
            System.out.println(nums[i]);
        }

        int k = list.size();
        return k;
    }
}
