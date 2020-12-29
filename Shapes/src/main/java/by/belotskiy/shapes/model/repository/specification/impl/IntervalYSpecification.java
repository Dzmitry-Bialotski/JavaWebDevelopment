package by.belotskiy.shapes.model.repository.specification.impl;

import by.belotskiy.shapes.model.entitiy.Ellipse;
import by.belotskiy.shapes.model.repository.specification.Specification;

public class IntervalYSpecification implements Specification<Ellipse> {

    private int left;
    private int right;

    public IntervalYSpecification(int left, int right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean specify(Ellipse ellipse) {
        int firstY = ellipse.getFirstPoint().getY();
        int secondY = ellipse.getSecondPoint().getY();
        boolean result = (firstY >= left && secondY >= left &&
                firstY <= right && secondY <= right);
        return result;
    }
}