package by.belotskiy.shapes.model.entitiy;

public class EllipseProperty {

    private double perimeter;
    private double square;

    public EllipseProperty(double perimeter, double square) {
        this.perimeter = perimeter;
        this.square = square;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EllipseProperty{");
        sb.append(", perimeter=").append(perimeter);
        sb.append("square=").append(square);
        sb.append('}');
        return sb.toString();
    }
}
