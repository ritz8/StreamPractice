package org.practice.general;

import java.util.Scanner;

public class Prime
{
    private static String checkForPrime(int num)
    {
        for (int i = 2; i < num; i++)
        {
            if(num % i == 0)
            {
                return (num + " is not a prime number");
            }
        }
        return (num + " is a prime number");
    }
    private static int inputFromUser()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a number you want to check for prime - ");
        int num = scanner.nextInt();
        scanner.close();
        return num;
    }

    public static void main(String[] args)
    {
        int num = inputFromUser();
        String result = checkForPrime(num);
        System.out.println(result);
    }
}
