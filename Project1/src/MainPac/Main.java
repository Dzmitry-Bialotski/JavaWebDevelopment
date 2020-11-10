package MainPac;

import com.epam.oop_style_tasks.entity.*;
import com.epam.oop_style_tasks.printer.*;
import com.epam.oop_style_tasks.service.*;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        TaskPrinter.printTask(1);
        int a = 5, wrong_digit = 14;
        int result = NumberService.getLastDigitOfSquareNumber(5);
        NumberPrinter.printLastDigitOfSquareNumber(a, result);

        TaskPrinter.printTask(2);
        Month month = Month.FEBRUARY;
        int year = 2020;
        int number_of_days = TimeService.getNumberOfDays(month, year);
        TimePrinter.printNumberOfDaysInMouth(number_of_days, month, year);

        TaskPrinter.printTask(3);
        Square bigSquare = new Square(10);
        Circle circle = GeometryService.getCircleInscribedInSquare(bigSquare);
        Square smallSquare = GeometryService.getSquareInscribedInCircle(circle);
        Double ratio = GeometryService.getAreaRatio(smallSquare, bigSquare);
        GeometryPrinter.printAreaRatio(ratio, smallSquare, bigSquare);

        TaskPrinter.printTask(4);
        ArrayList<Integer> numbers = SeedDataService.seedArrayList();
        System.out.println(NumberService.HasAtLeastTwoEvenNumbers(numbers));

        TaskPrinter.printTask(5);
        int perfect_number = 6;
        boolean is_perfect = NumberService.numberIsPerfect(perfect_number);
        NumberPrinter.printNumberIsPerfect(perfect_number, is_perfect);

        TaskPrinter.printTask(6);
        int seconds = 3670;
        int minutes = TimeService.getFullMinutes(seconds);
        int hours = TimeService.getFullHours(seconds);
        TimePrinter.printNumberOfSeconds(seconds);
        TimePrinter.printNumberOfMinutes(minutes);
        TimePrinter.printNumberOfHours(hours);
    }
}
