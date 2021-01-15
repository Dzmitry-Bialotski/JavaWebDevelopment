package by.belotskiy.composite.reader;

import by.belotskiy.composite.exception.ReaderException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TextReaderTest {
    @DataProvider
    public Object[][] filepath() {
        return new Object[][]{
                {"src/main/resources/data/default.txt"},
                {"src/main/resources/data/text10.txt"},
        };
    }
    @Test(dataProvider = "filepath")
    public void readerTest(String filepath) throws ReaderException {
        TextReader textReader = new TextReader();
        String result =textReader.read(filepath);
        assertEquals(result, "    Some default text.");
    }
}