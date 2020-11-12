package com.epam.oop_style_tasks.task5.printer;

public class NumberPrinter {
    public void printNumberIsPerfect(int number, boolean isPerfect)
    {
        if(isPerfect) {
            System.out.println("Number " + number + " is Perfect!!!");
        } else {
            System.out.println("Number " + number + " is not Perfect(((");
        }
    }
}
