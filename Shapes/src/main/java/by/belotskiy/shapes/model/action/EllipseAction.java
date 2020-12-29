package by.belotskiy.shapes.model.action;

import by.belotskiy.shapes.model.entitiy.Ellipse;
import by.belotskiy.shapes.model.entitiy.Point;

import static java.lang.Math.PI;
import static java.lang.Math.pow;

public class EllipseAction {

    public boolean isEllipse(Ellipse ellipse){
        return (ellipse.getFirstPoint().getX() != ellipse.getSecondPoint().getX() &&
                ellipse.getFirstPoint().getY() != ellipse.getSecondPoint().getY());
    }

    public double calculatePerimeter(Ellipse ellipse){
        double a = calculateDistanceX(ellipse) / 2.0;
        double b = calculateDistanceY(ellipse) / 2.0;
        double perimeter = 4 * (PI * a * b + pow(2, a - b)) / (a + b);
        return perimeter;

    }

    public double calculateSquare(Ellipse ellipse){
        double a = calculateDistanceX(ellipse) / 2.0;
        double b = calculateDistanceY(ellipse) / 2.0;
        double square = PI * a * b;
        return square;
    }

    public boolean isCircle(Ellipse ellipse){
        double a = calculateDistanceX(ellipse);
        double b = calculateDistanceY(ellipse);
        return a == b;
    }

    public boolean intersectsCoordinateLineX(Ellipse ellipse){
        Point firstPoint = ellipse.getFirstPoint();
        Point secondPoint = ellipse.getSecondPoint();
        return firstPoint.getY() * secondPoint.getY() <= 0;
    }

    public boolean intersectsCoordinateLineY(Ellipse ellipse){
        Point firstPoint = ellipse.getFirstPoint();
        Point secondPoint = ellipse.getSecondPoint();
        return firstPoint.getX() * secondPoint.getX() <= 0;
    }

    private double calculateDistanceX(Ellipse ellipse){
        int firstX = ellipse.getFirstPoint().getX();
        int secondX = ellipse.getSecondPoint().getX();
        double distanceX = firstX > secondX ? firstX - secondX : secondX - firstX;
        return distanceX;
    }

    private double calculateDistanceY(Ellipse ellipse){
        int firstY = ellipse.getFirstPoint().getY();
        int secondY = ellipse.getSecondPoint().getY();
        double distanceY = firstY > secondY ? firstY - secondY : secondY - firstY;
        return distanceY;
    }
}
