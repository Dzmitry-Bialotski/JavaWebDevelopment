package com.epam.oop_style_tasks.printer;
import  com.epam.oop_style_tasks.entity.*;
public class GeometryPrinter {
    public static void printAreaRatio(double ratio, Square sq1, Square sq2)
    {
        System.out.println("Area Ratio of the " + sq1 + " to the " + sq2
        + " is " + String.format("%.4f", ratio));
    }
}
