package com.epam.oop_style_tasks;

import com.epam.oop_style_tasks.task1.exception.DigitException;
import com.epam.oop_style_tasks.task1.service.DigitService;
import com.epam.oop_style_tasks.task10.entity.FunctionTable;
import com.epam.oop_style_tasks.task10.service.FunctionService;
import com.epam.oop_style_tasks.task8.entity.IFunctionable;
import com.epam.oop_style_tasks.task2.entity.Month;
import com.epam.oop_style_tasks.task2.service.DateService;
import com.epam.oop_style_tasks.task3.entity.Circle;
import com.epam.oop_style_tasks.task3.entity.Square;
import com.epam.oop_style_tasks.task3.service.GeometryService;
import com.epam.oop_style_tasks.task4.service.ArrayService;
import com.epam.oop_style_tasks.task4.service.SeedDataService;
import com.epam.oop_style_tasks.task5.service.PerfectService;
import com.epam.oop_style_tasks.task6.service.TimeService;
import com.epam.oop_style_tasks.task8.service.SeedFunctionService;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;
import static org.testng.Assert.assertEquals;

public class ServiceTest {
    @Test
    public void testTask1() {
        int digit = 5;
        DigitService digitService = new DigitService();
        try{
            int result = digitService.calculateLastDigitOfSquareNumber(digit);
            assertEquals(digit, 5);
        }
        catch (DigitException e) {
            System.out.println(e.getMessage());
            assertTrue(false);
        }
    }
    @Test
    public void testTask2() {
        Month month = Month.FEBRUARY;
        int year = 2020;
        int number_of_days = DateService.getNumberOfDays(month, year);
        assertEquals(number_of_days, 29);
    }
    @Test
    public void testTask3() {
        Square bigSquare = new Square(10);
        GeometryService geometryService = new GeometryService();
        Circle circle = geometryService.calculateCircleInscribedInSquare(bigSquare);
        Square smallSquare = geometryService.calculateSquareInscribedInCircle(circle);
        Double ratio = geometryService.calculateAreaRatio(smallSquare, bigSquare);
        String.format("%.4f", ratio);
        assertEquals(String.format("%.4f", ratio), String.format("%.4f", 0.5));
    }
    @Test
    public void testTask4() {
        SeedDataService seedDataService = new SeedDataService();
        int[] numbers = seedDataService.createArrayWithTwoEvenNumbers();
        ArrayService arrayService = new ArrayService();
        boolean result = arrayService.HasAtLeastTwoEvenNumbers(numbers);
        assertTrue(result);

    }
    @Test
    public void testTask5() {
        int perfect_number = 6;
        PerfectService perfectService = new PerfectService();
        boolean is_perfect = perfectService.numberIsPerfect(perfect_number);
        assertTrue(is_perfect);

    }
    @Test
    public void testTask6() {
        int seconds = 3670;
        TimeService timeService = new TimeService();
        int minutes = timeService.calculateFullMinutes(seconds);
        int hours = timeService.calculateFullHours(seconds);
        assertEquals(seconds, 3670);
        assertEquals(minutes, 61);
        assertEquals(hours, 1);
    }
    @Test
    public void testTask8() {
        SeedFunctionService seedFunctionService = new SeedFunctionService();
        IFunctionable functionTask8 = seedFunctionService.seedFunctionForTask8();
        double x = 4.;
        double y = functionTask8.calculate(x);
        assertEquals(y, 5.);

    }
    @Test
    public void testTask9() {

        Circle circle9 = new Circle(10);
        assertEquals(circle9.calculateArea(), 10 * 10 * Math.PI);
        assertEquals(circle9.calculateCircumference(), 20 * Math.PI);
    }
    @Test
    public void testTask10() {
        FunctionService functionService = new FunctionService();
        FunctionTable functionTable = functionService.createFunctionTable(0, Math.PI/4, Math.PI/20,
                (arg) -> Math.tan(arg));
        assertEquals(functionTable.getArguments().get(0), 0.0);
        assertEquals(functionTable.getValues().get(0), 0.0);
    }

}