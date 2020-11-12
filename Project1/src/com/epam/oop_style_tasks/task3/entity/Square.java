package com.epam.oop_style_tasks.task3.entity;

public class Square {
    private double side;
    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
    public double calculateArea() {
        return side * side;
    }
    @Override
    public String toString() {
        return "Square with the side = " + side;
    }
}