package org.practice.string;

import java.util.HashMap;
import java.util.Scanner;

public class Occurrence
{
    public static void getOccurrenceOfCharacters(String word)
    {
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 1;
        for (char letter : word.toCharArray())
        {
            if(letter == ' ')
            {
                continue;
            }
            if(map.containsKey(letter))
            {
                int num = map.get(letter);
                map.put(letter, ++num);
            }
            else
            {
                map.put(letter, count);
            }
        }
        System.out.println(map);
    }

    public static String getInputFromUser()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the word or sentence - ");
        String word = scanner.nextLine();
        scanner.close();
        return word;
    }

    public static void main(String[] args)
    {
        String word = getInputFromUser();
        getOccurrenceOfCharacters(word.toLowerCase());
    }
}