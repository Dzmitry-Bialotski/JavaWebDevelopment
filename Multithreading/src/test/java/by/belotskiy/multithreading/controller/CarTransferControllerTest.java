package by.belotskiy.multithreading.controller;

import by.belotskiy.multithreading.entity.Car;
import by.belotskiy.multithreading.entity.Ferry;
import by.belotskiy.multithreading.parser.impl.CarParser;
import by.belotskiy.multithreading.parser.impl.FerryParser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class CarTransferControllerTest {

    CarTransferController controller;
    List<Car> cars;
    Ferry ferry;

    @BeforeClass
    public void initialize() {
        FerryParser ferryParser = new FerryParser();
        ferry = ferryParser.parse("src/test/resources/Ferry.xml");
        CarParser carParser = new CarParser();
        cars = carParser.parse("src/test/resources/Cars.xml");
        controller = new CarTransferController();
    }

    @Test
    public void testTransfer() throws Exception {
        boolean isSuccess = controller.transfer(cars , ferry);
        assertTrue(isSuccess);
    }
}
