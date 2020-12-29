package by.belotskiy.shapes.model.entitiy;

import by.belotskiy.shapes.model.observer.EllipseEvent;
import by.belotskiy.shapes.model.observer.Observable;
import by.belotskiy.shapes.model.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Ellipse extends AbstractShape2D implements Observable {

    private Point firstPoint;
    private Point secondPoint;
    private List<Observer> observers = new ArrayList<Observer>();

    public Ellipse(long shapeId, Point firstPoint, Point secondPoint) {
        super(shapeId);
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
    }

    public Point getFirstPoint() {
        return firstPoint;
    }

    public void setFirstPoint(Point firstPoint) {
        this.firstPoint = firstPoint;
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    public void setSecondPoint(Point secondPoint) {
        this.secondPoint = secondPoint;
    }

    public void attach(Observer observer) {
        if(observer != null){
            observers.add(observer);
        }
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        final EllipseEvent event = new EllipseEvent(this);
        observers.forEach(observer -> observer.parameterChanged(event));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ellipse ellipse = (Ellipse) o;
        return getShapeId() == ellipse.getShapeId() &&
                firstPoint.equals(ellipse.firstPoint) &&
                secondPoint.equals(ellipse.secondPoint);
    }

    @Override
    public int hashCode() {
        int result = 31 * firstPoint.hashCode();
        result = 31 * result * secondPoint.hashCode();
        result = 31 * result * (int)getShapeId();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ellipse{");
        sb.append("shapeId=").append(this.getShapeId());
        sb.append(", firstPoint=").append(firstPoint);
        sb.append(", secondPoint=").append(secondPoint);
        sb.append('}');
        return sb.toString();
    }
}
