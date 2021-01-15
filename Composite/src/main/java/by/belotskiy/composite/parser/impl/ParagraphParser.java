package by.belotskiy.composite.parser.impl;

import by.belotskiy.composite.component.Component;
import by.belotskiy.composite.component.TextComponentType;
import by.belotskiy.composite.component.impl.TextComponent;
import by.belotskiy.composite.parser.Parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParagraphParser implements Parser {
    private static final  String PARAGRAPH_SEPARATOR = "\\n\\s{4}|\\s{4}|\\t+";
    private static final String NULL_STRING = "";
    private final Parser nextParser = new SentenceParser();

    @Override
    public Component parse(String text) {
        Component result = new TextComponent(TextComponentType.TEXT);
        String[] paragraphsArray = text.split(PARAGRAPH_SEPARATOR);
        List<String> paragraphs = Arrays.stream(paragraphsArray)
                .filter(s -> !s.equals(NULL_STRING))
                .collect(Collectors.toList());
        for (String paragraph : paragraphs) {
            Component sentence = nextParser.parse(paragraph);
            result.add(sentence);
        }
        return result;
    }
}
