package by.belotskiy.composite.component.impl;

import by.belotskiy.composite.component.Component;
import by.belotskiy.composite.component.TextComponentType;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextComponent implements Component {

    private static final String SPACE = " ";
    private static final String NEXT_LINE = "\n";
    private static final String TAB = "\t";
    private static final String WORD_REGEX = "[\\p{L}\\p{N}]+([\\p{P}\\p{S}]+[\\p{L}\\p{N})]+)*";

    private final TextComponentType type;
    private final List<Component> components;

    public TextComponent(TextComponentType type) {
        this.type = type;
        this.components = new ArrayList<>();
    }

    @Override
    public void add(Component component) {
        components.add(component);
    }

    @Override
    public void remove(Component component) {
        components.remove(component);
    }

    @Override
    public Component getChild(int index) {
        return components.get(index);
    }

    @Override
    public int size() {
        return components.size();
    }

    private boolean isWord() {
        Pattern wordPattern = Pattern.compile(WORD_REGEX);
        Matcher matcher = wordPattern.matcher(this.components.toString());
        boolean result = matcher.find();
        return result;
    }

    @Override
    public TextComponentType getTextComponentType() {
        return type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < components.size(); i++) {
            Component currentComponent = components.get(i);
            if (currentComponent.getTextComponentType() == TextComponentType.CHARACTER) {
                sb.append(currentComponent);
            } else {
                if (currentComponent.getTextComponentType() == TextComponentType.PUNCTUATION) {
                    if (currentComponent.toString().matches("[”),:;-]")) {
                        if (i < components.size() - 1) {
                            Component nextComponent = components.get(i + 1);
                            sb.append((nextComponent.getTextComponentType() == TextComponentType.PUNCTUATION
                                    && nextComponent.toString().matches("[,:;]")) ?
                                    currentComponent : currentComponent + SPACE);
                        } else {
                            sb.append(currentComponent).append(SPACE);
                        }
                    } else {
                        sb.append(currentComponent);
                    }
                } else {
                    if (currentComponent.getTextComponentType() == TextComponentType.WORD
                            || currentComponent.getTextComponentType() == TextComponentType.SENTENCE) {
                        if (i < components.size() - 1) {
                            Component nextComponent = components.get(i + 1);
                            sb.append((nextComponent.getTextComponentType() == TextComponentType.PUNCTUATION && !nextComponent.toString().matches("[“(-]")) ?
                                    currentComponent : currentComponent + SPACE);
                        } else {
                            sb.append(currentComponent).append(SPACE);
                        }
                    } else {
                        sb.append(NEXT_LINE).append(TAB).append(currentComponent.toString().trim());
                    }
                }
            }
        }
        return sb.toString().replaceFirst("\n", "");
    }
}
