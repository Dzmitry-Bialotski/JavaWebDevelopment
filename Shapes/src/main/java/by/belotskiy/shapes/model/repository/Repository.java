package by.belotskiy.shapes.model.repository;

import by.belotskiy.shapes.model.entitiy.AbstractShape2D;
import by.belotskiy.shapes.model.repository.specification.Specification;

import java.util.Comparator;
import java.util.List;

public interface Repository<T extends AbstractShape2D> {

    void add(T shape);
    void remove(T shape);
    T get(int index);
    List<T> sort(Comparator<? super T> comparator);
    List<T> query(Specification<T> specification);
}
