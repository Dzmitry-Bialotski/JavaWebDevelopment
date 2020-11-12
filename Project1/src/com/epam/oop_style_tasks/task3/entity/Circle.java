package com.epam.oop_style_tasks.task3.entity;

public class Circle {
    private double radius;
    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }
    @Override
    public String toString() {
        return "Circle with the side = " + radius;
    }
}
