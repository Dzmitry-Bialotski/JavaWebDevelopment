package com.epam.oop_style_tasks.entity;

public class Square {
    private double side;
    public Square(double side)
    {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
    public double getArea()
    {
        return side * side;
    }
    @Override
    public String toString() {
        return "Square with the side = " + side;
    }
}
