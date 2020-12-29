package by.belotskiy.shapes.model.factory;

import by.belotskiy.shapes.model.entitiy.AbstractShape2D;

import java.util.List;

public interface ShapeFactory<T extends AbstractShape2D> {

    T createInstance(List<Integer> coordinates);
}
