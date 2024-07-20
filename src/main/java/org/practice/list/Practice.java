package org.practice.list;

import java.util.Arrays;
import java.util.List;

public class Practice {
    public static void main(String[] args) {
        //smallElement();
        smallElementWithStream();
    }

    private static void smallElement() {
        List<Integer> list = Arrays.asList(8,2,5,3,9,1,7);
        int min = Integer.MAX_VALUE;
        for (int i : list) {
            if (i < min)
                min = i;
        }
        System.out.println(min);
    }

    private static void smallElementWithStream() {
        List<Integer> list = Arrays.asList(8,2,5,3,9,1,7);
        int min = list.stream().min(Integer::compareTo).get();
        System.out.println(min);
    }
}
