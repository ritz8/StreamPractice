package org.practice.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Temp
{
    public static void main(String[] args) {
        //stringUpper();
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        int k = removeElement(nums, val);
        System.out.println(k);
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

    private static int removeElement(int[] nums, int val){
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
        return out.length;
    }
}
