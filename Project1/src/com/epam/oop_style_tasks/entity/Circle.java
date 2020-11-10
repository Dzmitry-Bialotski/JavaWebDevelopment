package com.epam.oop_style_tasks.entity;

public class Circle {
    private double radius;
    public Circle(double radius)
    {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle with the side = " + radius;
    }
}
