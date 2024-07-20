package org.practice.interview;

import java.util.*;

public class EpamInterview {
    public static void main(String[] args){
        //myMethod1();
        myMethod2();
    }

    private static  void myMethod2() {
        int[] arr = { 1, 2, 2, 2, 2, 3, 4, 7, 8, 8 ,1};
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer> list = Arrays.stream(arr).boxed().toList();
        for(int i : list) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }

        int firstIndex;
        int lastIndex;
        int element;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            element = entry.getKey();
            if(entry.getValue() > 1) {
                firstIndex = list.indexOf(element);
                lastIndex = list.lastIndexOf(element);
            }
            else {
                firstIndex = lastIndex = list.indexOf(element);
            }
            System.out.println("element=" + element + ", firstIndex=" + firstIndex + ", lastIndex=" + lastIndex);
        }
    }

    private static void myMethod1() {
        int[] arr = { 1, 2, 2, 2, 2, 3, 4, 7, 8, 8 ,1};
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer> list = Arrays.stream(arr).boxed().toList();
        for(int i : list) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }

        Set<Integer> items = count.keySet();
        int firstIndex;
        int lastIndex;
        int size = items.stream().toList().size();
        int element;
        for(int i = 0; i < list.size() && i < size; i++) {
            element = items.stream().toList().get(i);
            if(count.get(element) > 1) {
                firstIndex = list.indexOf(element);
                lastIndex = list.lastIndexOf(element);
            }
            else {
                firstIndex = lastIndex = list.indexOf(element);
            }
            System.out.println("element=" + element + ", firstIndex=" + firstIndex + ", lastIndex=" + lastIndex);
        }
    }
}
