package by.belotskiy.composite.parser.impl;

import by.belotskiy.composite.component.Component;
import by.belotskiy.composite.parser.Parser;

public class TextParser implements Parser {
    private final Parser nextParser = new ParagraphParser();

    @Override
    public Component parse(String text) {
        Component result = nextParser.parse(text);
        return result;
    }
}
