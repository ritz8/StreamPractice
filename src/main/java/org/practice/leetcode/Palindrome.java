package org.practice.leetcode;

public class Palindrome {
    public static void main(String[] args) {
        int x = 54245;
        boolean res = isPalindrome(x);
        if (res)
            System.out.println(x + " is a palindrome number");
        else
            System.out.println(x + " is not a palindrome number");
    }

    private static boolean isPalindrome(int x) {
        if (x < 0)
            return  false;
        int digit;
        int temp = x;
        int rev = 0;
        while (temp > 0) {
            digit = temp % 10;
            rev = (rev * 10) + digit;
            temp /= 10;
        }
        return x == rev;
    }
}
