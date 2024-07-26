package org.practice.leetcode;

public class ValidParenthesis {
    public static void main(String[] args) {
        String s = "{[]}";
        boolean res = isValid(s);
        if (res)
            System.out.println("Valid");
        else
            System.out.println("Invalid");
    }

    private static boolean isValid(String s) {
        while (true) {
            if (s.contains("()"))
                s = s.replace("()", "");
            else if (s.contains("{}"))
                s = s.replace("{}", "");
            else if (s.contains("[]"))
                s = s.replace("[]", "");
            else
                return s.isEmpty();
        }
    }
}
