package com.epam.oop_style_tasks.printer;
import  com.epam.oop_style_tasks.entity.*;
public class GeometryPrinter {
    public static void printAreaRatio(double ratio, Square sq1, Square sq2)
    {
        System.out.println("Area Ratio of the " + sq1 + " to the " + sq2
        + " is " + String.format("%.4f", ratio));
    }
    public static void printNearestPoint(Point point) {
        System.out.println(" The nearest point is " + point);
    }
    public static void printInfoTask9(Circle circle) {
        System.out.println("The circle with radius =  " + circle.getRadius() + " has area = "
                            + String.format("%.4f", circle.getArea())
                            + " and circumference = " + String.format("%.4f", circle.getCircumference()));
    }
}
