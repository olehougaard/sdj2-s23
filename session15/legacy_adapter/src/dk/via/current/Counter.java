package dk.via.current;

import java.util.HashMap;

public class Counter<T> {
    private final HashMap<T, Integer> theCount;

    public Counter() {
        theCount = new HashMap<>();
    }

    public void add(T element) {
        theCount.put(element, theCount.getOrDefault(element, 0) + 1);
    }

    public HashMap<T, Integer> getTheCount() {
        return (HashMap<T, Integer>) theCount.clone();
    }
}
