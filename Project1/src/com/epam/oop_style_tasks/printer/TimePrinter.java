package com.epam.oop_style_tasks.printer;

import com.epam.oop_style_tasks.entity.Month;

public class TimePrinter {
    public static void printNumberOfDaysInMouth(int days, Month month, int year)
    {
        System.out.println(days + " days in " + month + " in " + year);
    }
    public static void printNumberOfHours(int hours)
    {
        System.out.println("Hours passed: " + hours);
    }
    public static void printNumberOfMinutes(int minutes)
    {
        System.out.println("Minutes passed: " + minutes);
    }
    public static void printNumberOfSeconds(int seconds)
    {
        System.out.println("Seconds passed: " + seconds);
    }

}
