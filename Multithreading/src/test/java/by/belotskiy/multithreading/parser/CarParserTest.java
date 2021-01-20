package by.belotskiy.multithreading.parser;

import by.belotskiy.multithreading.controller.CarTransferController;
import by.belotskiy.multithreading.entity.Car;
import by.belotskiy.multithreading.parser.impl.CarParser;
import by.belotskiy.multithreading.parser.impl.FerryParser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class CarParserTest {

    List<Car> cars = new ArrayList<>();

    @BeforeClass
    public void initialize() {
        Car car1 = new Car(2000,20);
        Car car2 = new Car(1000,10);
        Car car3 = new Car(1700,25);
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
    }
    @Test
    public void testParse(){
        List parseCars = new CarParser().parse("src/test/resources/Cars.xml");
        assertEquals(cars, parseCars);
    }

}