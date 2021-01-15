package by.belotskiy.composite.parser;

import by.belotskiy.composite.component.Component;

public interface Parser {
    Component parse(String text);
}
