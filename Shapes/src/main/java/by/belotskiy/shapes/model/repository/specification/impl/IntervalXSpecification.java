package by.belotskiy.shapes.model.repository.specification.impl;

import by.belotskiy.shapes.model.entitiy.Ellipse;
import by.belotskiy.shapes.model.repository.specification.Specification;

public class IntervalXSpecification implements Specification<Ellipse> {

    private int left;
    private int right;

    public IntervalXSpecification(int left, int right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean specify(Ellipse ellipse) {
        int firstX = ellipse.getFirstPoint().getX();
        int secondX = ellipse.getSecondPoint().getX();
        boolean result = (firstX >= left && secondX >= left &&
                          firstX <= right && secondX <= right);
        return result;
    }
}
