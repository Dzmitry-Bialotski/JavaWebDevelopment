package com.epam.oop_style_tasks.task3.service;

import com.epam.oop_style_tasks.task3.entity.Circle;
import com.epam.oop_style_tasks.task3.entity.Square;

public class GeometryService {
    public Circle calculateCircleInscribedInSquare(Square square) {
        return new Circle(square.getSide()/2);
    }
    public Square calculateSquareInscribedInCircle(Circle circle) {
        return new Square(circle.getRadius()*Math.sqrt(2));
    }
    public double calculateAreaRatio(Square square1, Square square2) {
        return square1.calculateArea()/square2.calculateArea();
    }
}
