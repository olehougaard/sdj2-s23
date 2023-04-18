package dk.via.exercise13_1;

import java.util.ArrayList;

public class NumberList {
    private final ArrayList<Double> elements;
    private double sum;

    public NumberList() {
        sum = 0;
        elements = new ArrayList<>();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return elements.size();
    }

    public double get(int index) {
        if (index >= size()) throw new ArrayIndexOutOfBoundsException("Out of bounds");
        return elements.get(index);
    }

    public double remove(int index) {
        if (index >= size()) throw new ArrayIndexOutOfBoundsException("Out of bounds");
        return elements.remove(index);
    }

    public double sum() {
        return sum;
    }

    public void add(double element) {
        this.elements.add(element);
        sum += element;
    }
}
