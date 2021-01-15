package by.belotskiy.composite.parser.impl;

import by.belotskiy.composite.component.Component;
import by.belotskiy.composite.component.TextComponentType;
import by.belotskiy.composite.component.impl.CharacterComponent;
import by.belotskiy.composite.component.impl.TextComponent;
import by.belotskiy.composite.parser.Parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordParser implements Parser{
    private static final String WORD_REGEX = "[\\p{L}\\p{N}]+([\\p{P}\\p{S}]+[\\p{L}\\p{N})]+)*|[\\p{P}\\p{S}]";
    private static final String PUNCTUATION_REGEX = "[\\p{P}\\p{S}]";
    private final Parser nextParser = new CharacterParser();

    @Override
    public Component parse(String text) {
        Component result = new TextComponent(TextComponentType.SENTENCE);
        List<String> words = parseText(text);
        for (String word : words) {
            Component character;
            if (!word.matches(PUNCTUATION_REGEX)) {
                character = nextParser.parse(word);
            } else {
                character = new CharacterComponent(word.charAt(0), TextComponentType.PUNCTUATION);
            }
            result.add(character);
        }
        return result;
    }

    private List<String> parseText(String text) {
        List<String> words = new ArrayList<>();
        Pattern wordRegex = Pattern.compile(WORD_REGEX);
        Matcher matcher = wordRegex.matcher(text);
        while (matcher.find()) {
            words.add(matcher.group());
        }
        return words;
    }
}
