package org.practice.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        // 1,2,0,3,0,7
        List<Integer> numList = new ArrayList<>();
        Collections.addAll(numList, 1,2,0,3,0,7);
        System.out.println("Before formatting - ");
        printList(numList);
        System.out.println("After formatting - ");
        //printList(formatList(numList));
        //printList(formatListUsingStream(numList));
        formatListUsingStreamWithForEach(numList);
    }

    public static void printList(List<Integer> numList){
        for(int i : numList){
            System.out.print(i);
        }
        System.out.println();
    }

    private static List<Integer> formatList(List<Integer> numList){
        List<Integer> formatList = new ArrayList<>();
        int zeroCount = 0;
        for (int num : numList) {
            if (num != 0) {
                formatList.add(num);
            }
            else {
                zeroCount++;
            }
        }
        for(int i = 0; i < zeroCount; i++){
            formatList.add(0);
        }
        return formatList;
    }

    private static List<Integer> formatListUsingStream(List<Integer> numList){
        return Stream.concat(
                numList.stream().filter(num -> num != 0),
                numList.stream().filter(num -> num == 0)
        ).collect(Collectors.toList());
    }

    private static void formatListUsingStreamWithForEach(List<Integer> numList){
        Stream.concat(
                numList.stream().filter(num -> num != 0),
                numList.stream().filter(num -> num == 0)
        ).forEach(num -> System.out.print(num));
    }
}
