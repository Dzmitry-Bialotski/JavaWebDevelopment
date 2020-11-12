package com.epam.oop_style_tasks.task9.printer;

import com.epam.oop_style_tasks.task9.entity.Circle;

public class GeometryPrinter {
    public  void printInfoCircle(Circle circle) {
        System.out.println("The circle with radius =  " + circle.getRadius() + " has area = "
                + String.format("%.4f", circle.calculateArea())
                + " and circumference = " + String.format("%.4f", circle.calculateCircumference()));
    }
}
