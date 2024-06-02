package org.practice.general;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Temp
{
    public static void main(String[] args)
    {
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
}
