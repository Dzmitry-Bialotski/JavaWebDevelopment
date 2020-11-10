package com.epam.oop_style_tasks.printer;

public class NumberPrinter {
    public static void printLastDigitOfSquareNumber(int lastDigit)
    {
        System.out.println("The Last digit is" + lastDigit);
    }
    public static void printLastDigitOfSquareNumber(int lastDigit, int lastDigitOfSquare)
    {
        System.out.println("The Last digit of number, which ends in " + lastDigit + " is " + lastDigitOfSquare);
    }
    public static void printNumberIsPerfect(int number, boolean isPerfect)
    {
        if(isPerfect)
        {
            System.out.println("Number " + number + " is Perfect!!!");
        }
        else
        {
            System.out.println("Number " + number + " is not Perfect(((");
        }
    }
}
