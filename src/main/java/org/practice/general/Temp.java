package org.practice.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Temp
{
    public static void main(String[] args) {
        //stringUpper();
        removeElement();

    }

    private static void stringUpper() {
        String name = "Ritesh";
        List<Character> chn = new ArrayList<>();
        for (char ch : name.toCharArray())
        {
            int n = ch;
            if(n < 91 && n > 64)
            {
                chn.add(ch);
                continue;
            }
            else
            {
                ch = (char)(n-32);
                chn.add(ch);
            }
        }
        System.out.println(chn);
        String name1 = chn.stream().map(e -> e.toString()).collect(Collectors.joining());
        System.out.println(name1);
    }

    private static void removeElement(){
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val)
                count++;
        }
        int[] out = new int[count];
        for (int i = 0, j = 0; i < nums.length && j <= i; i++) {
            if (nums[i] != val){
                out[j] = nums[i];
                j++;
            }
        }
        nums = out;
        System.out.println(Arrays.toString(nums));
        System.out.println(out.length);
    }

    private static void luckyNumber() {
        int[][] matrix = {{7,8},{1,2}};

        List<Integer> list = new ArrayList<>();

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < min)
                    min = matrix[i][j];
            }
            list.add(min);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > max)
                    max = matrix[i][j];
            }
            list.add(max);
        }


    }
}
