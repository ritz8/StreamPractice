package org.practice.leetcode;

/*
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4
 */

public class SearchInsPos {
    public static void main(String[] args) {
        int[] nums = {1,3,8,11};
        int target = 11;
        int pos = searchInsert(nums, target);
        System.out.println(pos);
    }

    private static int searchInsert(int[] nums, int target) {
        if (nums[nums.length-1] == target)
            return (nums.length-1);
        if (nums[0] > target)
            return 0;
        for (int i = 0; i < (nums.length - 1); i++) {
            if (nums[i] == target)
                return i;
            else if (target > nums[i] && target < nums[i+1])
                return i+1;
        }
        return nums.length;
    }
}
