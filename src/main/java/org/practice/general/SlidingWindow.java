package org.practice.general;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SlidingWindow {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 3, 1, 1};
        getSubWindows(nums);
    }

    private static void getSubWindows(int[] nums) {
        int left;
        int right;
        left = right = 0;
        int k = 5;
        int sum = 0;
        int temp = 0;
        int[] out;

        for (; right < nums.length;) {
            if (left == right) {
                sum = nums[left];
                out = new int[1];
            }
            else {
                sum = temp + nums[right];
                out = new int[(right - left) + 1];
            }
            if (sum <= k) {
                for (int i = left, j = right, x = 0; i <= j; i++, x++) {
                    out[x] = nums[i];
                }
                System.out.println(Arrays.toString(out));
                right++;
                temp = sum;
            }
            else {
                left++;
                temp = nums[left];
            }

        }
    }
}
