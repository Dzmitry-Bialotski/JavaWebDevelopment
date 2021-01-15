package by.belotskiy.composite.component;

public interface Component {
    void add(Component component);
    void remove(Component component);
    Component getChild(int index);
    int size();
    TextComponentType getTextComponentType();
    String toString();
}
