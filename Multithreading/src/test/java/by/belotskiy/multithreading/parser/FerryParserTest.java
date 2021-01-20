package by.belotskiy.multithreading.parser;

import by.belotskiy.multithreading.entity.Car;
import by.belotskiy.multithreading.entity.Ferry;
import by.belotskiy.multithreading.parser.impl.CarParser;
import by.belotskiy.multithreading.parser.impl.FerryParser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class FerryParserTest {

    Ferry ferry;

    @BeforeClass
    public void initialize() {
        ferry = Ferry.getInstance();
        ferry.setFerryArea(15000);
        ferry.setFerryMaxWeight(4000);
    }
    @Test
    public void testParse() {
        Ferry parseFerry = new FerryParser().parse("src/test/resources/FerryBoat.xml");
        assertEquals(parseFerry, ferry);
    }
}