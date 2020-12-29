package by.belotskiy.shapes.reader;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileReaderTest {
    private FileReader fileReader;
    private List<String> lines, defaultLines;
    private static final String CORRECT_FILE_NAME = "src/main/resources/data/ellipse.txt";
    private static final String INCORRECT_FILE_NAME = "qwerty";

    @BeforeTest
    private void init(){
        fileReader = new FileReader();
        lines = new ArrayList<>(Arrays.asList("12 12 11 14",
                "1 2 4 5",
                "12 3 5 7e",
                "-1 -3 4 5"));
        defaultLines = new ArrayList<>(Arrays.asList(
                "1 2 4 5",
                "12 3 5 7e",
                "7 7 7 7"));
    }

    @Test
    public void readDataCorrectFileNameTest(){
        List<String> actual = fileReader.readData(CORRECT_FILE_NAME);
        assertEquals(actual, lines);
    }

    @Test
    public void readDataIncorrectFileNameTest(){
        List<String> actual = fileReader.readData(INCORRECT_FILE_NAME);
        assertEquals(actual, defaultLines);
    }
}
