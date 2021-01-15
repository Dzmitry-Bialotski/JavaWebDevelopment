package by.belotskiy.composite.parser.impl;

import by.belotskiy.composite.exception.ReaderException;
import by.belotskiy.composite.parser.Parser;
import by.belotskiy.composite.reader.TextReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TextParserTest {
    @DataProvider
    public Object[][] texts() {
        return new Object[][]{
                {"\tIt has survived - not only (five) centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the “Динамо” (Рига) with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker Faclon9 including versions of Lorem Ipsum!\n" +
                        "\tIt is a long a!=b established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Ipsum is that it has a more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here), content here's, making it look like readable English?\n" +
                        "\tIt is a established fact that a reader will be of a page when looking at its layout…\n" +
                        "\tBye бандерлоги."},
                {"\tSome default text."},
        };
    }

    @Test(dataProvider = "texts")
    public void parseTest(String expected){
        Parser parser = new TextParser();
        String actual = parser.parse(expected).toString();
        assertEquals(actual, expected);
    }
}
