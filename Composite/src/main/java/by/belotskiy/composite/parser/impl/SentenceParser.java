package by.belotskiy.composite.parser.impl;

import by.belotskiy.composite.component.Component;
import by.belotskiy.composite.component.TextComponentType;
import by.belotskiy.composite.component.impl.TextComponent;
import by.belotskiy.composite.parser.Parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SentenceParser implements Parser {
    private static final String SENTENCE_SEPARATOR = "(?<=[.!?…]\\s)";
    private final Parser nextParser = new WordParser();

    @Override
    public Component parse(String text) {
        Component result = new TextComponent(TextComponentType.PARAGRAPH);
        String[] sentencesArray = text.split(SENTENCE_SEPARATOR);
        List<String> sentences = Arrays.stream(sentencesArray)
                .collect(Collectors.toList());
        for (String sentence : sentences) {
            Component word = nextParser.parse(sentence);
            result.add(word);
        }
        return result;
    }
}
