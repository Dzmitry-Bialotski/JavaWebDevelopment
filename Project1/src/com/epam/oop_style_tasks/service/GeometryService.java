package com.epam.oop_style_tasks.service;

import com.epam.oop_style_tasks.entity.Circle;
import com.epam.oop_style_tasks.entity.Point;
import com.epam.oop_style_tasks.entity.Square;

public class GeometryService {
    public static Circle getCircleInscribedInSquare(Square square)
    {
        return new Circle(square.getSide()/2);
    }
    public static Square getSquareInscribedInCircle(Circle circle)
    {
        return new Square(circle.getRadius()*Math.sqrt(2));
    }
    public static double getAreaRatio(Square square1, Square square2)
    {
        return square1.getArea()/square2.getArea();
    }
    public static Point getNearestPoint(Point point1, Point point2) {
        double distance1 = Math.hypot(point1.getX(), point1.getY());
        double distance2 = Math.hypot(point2.getX(), point2.getY());
        return distance1 > distance2 ? point2 : point1;
    }
}
