package by.belotskiy.shapes.model.entitiy.comparator;

import by.belotskiy.shapes.model.entitiy.EllipseProperty;

import java.util.Comparator;

public class EllipseSquareComparator implements Comparator<EllipseProperty> {

    @Override
    public int compare(EllipseProperty firstProperty, EllipseProperty secondProperty) {
        Double firstSquare = firstProperty.getSquare();
        Double secondSquare = secondProperty.getSquare();
        return firstSquare.compareTo(secondSquare);
    }
}
