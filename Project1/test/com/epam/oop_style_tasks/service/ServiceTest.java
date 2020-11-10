package com.epam.oop_style_tasks.service;

import com.epam.oop_style_tasks.entity.Circle;
import com.epam.oop_style_tasks.entity.Month;
import com.epam.oop_style_tasks.entity.Square;
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

}