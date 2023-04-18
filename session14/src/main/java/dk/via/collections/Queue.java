package dk.via.collections;

import java.util.ArrayList;

public class Queue<E> {
    private ArrayList<E> elements;

    public Queue() {
        elements = new ArrayList<>();
    }

    public int size() {
        return elements.size();
    }

    public E peek() {
        if (size() == 0) {
            throw new IllegalStateException();
        }
        return elements.get(0);
    }

    public E leave() {
        throw new IllegalStateException();
    }

    public void enter(E e) {
        elements.add(e);
    }
}
