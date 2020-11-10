package com.epam.oop_style_tasks.service;

import java.util.ArrayList;

public class NumberService {
    public static int getLastDigitOfSquareNumber(int lastDigit)
    {
        if((lastDigit >= 10) || (lastDigit < 0))
            throw new NumberFormatException("Exception! Argument is not a digit");
        return lastDigit * lastDigit % 10;
    };
    public static boolean HasAtLeastTwoEvenNumbers(ArrayList<Integer> numbers)
    {
        int count = 0;
        for (Integer number : numbers) {
            if(number%2 == 0)
                count++;
            if(count >= 2)
                return true;
        }
        return false;
    }
    public static boolean numberIsPerfect(int n) {
        int summa =0;
        for(int i=1;i<n;i++) {
            if(n%i==0) summa+=i;
        }
        return summa==n ? true : false;
    }
}
