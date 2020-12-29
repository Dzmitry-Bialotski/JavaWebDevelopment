package by.belotskiy.shapes.model.repository.specification.impl;

import by.belotskiy.shapes.model.entitiy.Ellipse;
import by.belotskiy.shapes.model.repository.specification.Specification;

public class IdSpecification implements Specification<Ellipse> {

    private long ellipseId;

    public IdSpecification(long ellipseId){
        this.ellipseId = ellipseId;
    }

    @Override
    public boolean specify(Ellipse ellipse) {
        return ellipseId == ellipse.getShapeId();
    }
}
