package by.belotskiy.composite.parser.impl;

import by.belotskiy.composite.component.Component;
import by.belotskiy.composite.component.TextComponentType;
import by.belotskiy.composite.component.impl.CharacterComponent;
import by.belotskiy.composite.component.impl.TextComponent;
import by.belotskiy.composite.parser.Parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CharacterParser implements Parser {
    private static final String CHARACTER_SEPARATOR = "";
    private static final String NULL_STRING = "";

    @Override
    public Component parse(String text) {
        Component result = new TextComponent(TextComponentType.WORD);
        List<String> characters = Arrays.stream(text
                .split(CHARACTER_SEPARATOR))
                .filter(s -> !s.equals(NULL_STRING))
                .collect(Collectors.toList());
        for (String character : characters) {
            Component symbol = new CharacterComponent(character.charAt(0), TextComponentType.CHARACTER);
            result.add(symbol);
        }
        return result;
    }
}
