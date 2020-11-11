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

        TaskPrinter.printTask(7);

        Point point = new Point(1, 2);
        Point point1 = new Point(9, 8);
        Point nearestPoint = GeometryService.getNearestPoint(point1, point);
        GeometryPrinter.printNearestPoint(nearestPoint);

        TaskPrinter.printTask(8);
        IFunctionable functionTask8 = SeedDataService.seedFunctionForTask8();
        double x = 4.;
        double y = functionTask8.calculate(x);
        FunctionPrinter.printFunction(x, y);

        TaskPrinter.printTask(9);
        Circle circle9 = new Circle(10);
        GeometryPrinter.printInfoTask9(circle9);

        TaskPrinter.printTask(10);
        FunctionTable functionTable = FunctionService.getFunctionTable(0, Math.PI/4, Math.PI/20,
                (arg) -> Math.tan(arg));
        FunctionPrinter.printFunctionTable(functionTable);
    }
}
