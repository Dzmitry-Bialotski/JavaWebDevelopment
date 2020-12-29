package by.belotskiy.shapes.model.observer;

import by.belotskiy.shapes.model.entitiy.Ellipse;

import java.util.EventObject;

public class EllipseEvent extends EventObject {

    public EllipseEvent(Ellipse source) {
        super(source);
    }

    @Override
    public Object getSource() {
        return super.getSource();
    }
}
