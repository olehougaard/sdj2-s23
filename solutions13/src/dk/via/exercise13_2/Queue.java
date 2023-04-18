package dk.via.exercise13_2;

import java.util.ArrayList;
import java.util.List;

public class Queue<ElementType> {
    private final List<ElementType> elements;

    public Queue() {
        elements = new ArrayList<>();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public int size() {
        return elements.size();
    }

    public ElementType remove() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        return elements.remove(0);
    }

    public ElementType element() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        return elements.get(elements.size() - 1);
    }

    public void add(ElementType element) {
        if (element == null) throw new NullPointerException();
        this.elements.add(element);
    }
}
