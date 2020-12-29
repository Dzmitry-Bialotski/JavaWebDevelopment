package by.belotskiy.shapes.model.observer.impl;

import by.belotskiy.shapes.model.entitiy.Ellipse;
import by.belotskiy.shapes.model.observer.EllipseEvent;
import by.belotskiy.shapes.model.observer.Observer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EllipsePerimeterObserver implements Observer {

    private static final Logger logger = LogManager.getLogger();


    public void parameterChanged(EllipseEvent event) {
        Ellipse ellipse = (Ellipse) event.getSource();
    }
}
