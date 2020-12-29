package by.belotskiy.shapes.model.repository.specification;

import by.belotskiy.shapes.model.entitiy.AbstractShape2D;

public interface Specification<T extends AbstractShape2D> {
    boolean specify(T shape);
}
