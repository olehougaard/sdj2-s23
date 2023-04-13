package dk.via.collections;

import java.util.ArrayList;
import java.util.List;

public class Stack<ElementType> {
    private final List<ElementType> elements;

    public Stack() {
        elements = new ArrayList<>();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public int size() {
        return elements.size();
    }

    public ElementType pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return elements.remove(elements.size() - 1);
    }

    public ElementType peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return elements.get(elements.size() - 1);
    }

    public void push(ElementType element) {
        if (element == null) {
            throw new NullPointerException();
        }
        this.elements.add(element);
    }
}
