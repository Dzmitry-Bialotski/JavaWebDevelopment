package by.belotskiy.shapes.model.action;

import by.belotskiy.shapes.model.entitiy.Ellipse;
import by.belotskiy.shapes.model.entitiy.Point;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class EllipseActionTest {

    public final static double DELTA = 0.0001;
    private Ellipse ellipse, circle;
    private EllipseAction ellipseAction;

    @BeforeTest
    private void init(){
        circle = new Ellipse(1, new Point(3, 3), new Point(6, 6));
        ellipse = new Ellipse(2, new Point(-1, -1), new Point(2, 3));
        ellipseAction = new EllipseAction();
    }

    @Test
    public void isEllipseTest(){
        boolean condition = ellipseAction.isEllipse(ellipse);
        assertTrue(condition);
    }

    @Test
    public void isNotCircleTest(){
        boolean condition = ellipseAction.isCircle(ellipse);
        assertFalse(condition);
    }

    @Test
    public void isCircleTest(){
        boolean condition = ellipseAction.isCircle(circle);
        assertTrue(condition);
    }

    @Test
    public void calculatePerimeterTest(){
        double actual = ellipseAction.calculatePerimeter(ellipse);
        double expected = 11.5793;
        assertEquals(actual, expected, DELTA);
    }

    @Test
    public void calculateSquareTest(){
        double actual = ellipseAction.calculateSquare(ellipse);
        double expected = 9.42478;
        assertEquals(actual, expected, DELTA);
    }
}