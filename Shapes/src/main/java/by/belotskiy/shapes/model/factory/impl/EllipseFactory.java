package by.belotskiy.shapes.model.factory.impl;

import by.belotskiy.shapes.model.entitiy.Ellipse;
import by.belotskiy.shapes.model.entitiy.Point;
import by.belotskiy.shapes.model.factory.ShapeFactory;
import by.belotskiy.shapes.util.IdGenerator;

import java.util.List;

public class EllipseFactory implements ShapeFactory<Ellipse> {

    @Override
    public Ellipse createInstance(List<Integer> coordinates) {
        Point firstPoint = new Point(coordinates.get(0), coordinates.get(1));
        Point secondPoint = new Point(coordinates.get(2), coordinates.get(3));
        long id = IdGenerator.generateId();
        return new Ellipse(id, firstPoint, secondPoint);
    }
}
