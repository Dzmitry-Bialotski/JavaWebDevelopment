package com.epam.oop_style_tasks.service;

import com.epam.oop_style_tasks.entity.*;
import com.epam.oop_style_tasks.printer.GeometryPrinter;
import com.epam.oop_style_tasks.printer.NumberPrinter;
import com.epam.oop_style_tasks.printer.TaskPrinter;
import com.epam.oop_style_tasks.printer.TimePrinter;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;
import static org.testng.Assert.assertEquals;

public class ServiceTest {
    @Test
    public void testTask1() {
        int a = 5;
        int result = NumberService.getLastDigitOfSquareNumber(5);
        assertEquals(a, 5);
    }
    @Test
    public void testTask2() {
        Month month = Month.FEBRUARY;
        int year = 2020;
        int number_of_days = TimeService.getNumberOfDays(month, year);
        assertEquals(number_of_days, 29);
    }
    @Test
    public void testTask3() {
        Square bigSquare = new Square(10);
        Circle circle = GeometryService.getCircleInscribedInSquare(bigSquare);
        Square smallSquare = GeometryService.getSquareInscribedInCircle(circle);
        Double ratio = GeometryService.getAreaRatio(smallSquare, bigSquare);
        String.format("%.4f", ratio);
        assertEquals(String.format("%.4f", ratio), String.format("%.4f", 0.5));
    }
    @Test
    public void testTask4() {
        ArrayList<Integer> numbers = SeedDataService.seedArrayList();
        boolean result = NumberService.HasAtLeastTwoEvenNumbers(numbers);
        assertEquals(result, true);

    }
    @Test
    public void testTask5() {
        int perfect_number = 6;
        boolean is_perfect = NumberService.numberIsPerfect(perfect_number);
        assertEquals(is_perfect, true);

    }
    @Test
    public void testTask6() {
        int seconds = 3670;
        int minutes = TimeService.getFullMinutes(seconds);
        int hours = TimeService.getFullHours(seconds);
        assertEquals(seconds, 3670);
        assertEquals(minutes, 61);
        assertEquals(hours, 1);
    }
    @Test
    public void testTask7() {
        Point point = new Point(1, 2);
        Point point1 = new Point(9, 8);
        Point nearestPoint = GeometryService.getNearestPoint(point1, point);
        assertEquals(point, nearestPoint);
    }
    @Test
    public void testTask8() {
        IFunctionable functionTask8 = SeedDataService.seedFunctionForTask8();
        double x = 4.;
        double y = functionTask8.calculate(x);
        assertEquals(y, 5.);

    }
    @Test
    public void testTask9() {

        Circle circle9 = new Circle(10);
        assertEquals(circle9.getArea(), 10 * 10 * Math.PI);
        assertEquals(circle9.getCircumference(), 20 * Math.PI);
    }
    @Test
    public void testTask10() {
        FunctionTable functionTable = FunctionService.getFunctionTable(0, Math.PI/4, Math.PI/20,
                (arg) -> Math.tan(arg));

        assertEquals(functionTable.getArguments().get(0), 0.0);
        assertEquals(functionTable.getValues().get(0), 0.0);
    }

}