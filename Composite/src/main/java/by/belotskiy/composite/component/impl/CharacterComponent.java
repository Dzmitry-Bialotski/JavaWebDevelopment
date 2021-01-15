package by.belotskiy.composite.component.impl;

import by.belotskiy.composite.component.Component;
import by.belotskiy.composite.component.TextComponentType;


public class CharacterComponent implements Component {

    private char character;
    private final TextComponentType type;

    public CharacterComponent(char character, TextComponentType type) {
        this.character = character;
        this.type = type;
    }

    @Override
    public void add(Component component) {

    }

    @Override
    public void remove(Component component) {

    }

    @Override
    public Component getChild(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public TextComponentType getTextComponentType() {
        return type;
    }

    @Override
    public String toString() {
        return String.valueOf(this.character);
    }
}
