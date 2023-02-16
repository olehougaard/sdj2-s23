package solutions2_2;

import java.util.ArrayList;
import java.util.List;

public class ListContainer {
    private List<Integer> numbers;

    public ListContainer() {
        numbers = new ArrayList<Integer>();
    }

    public synchronized void add(int i) {
        numbers.add(i);
    }

    public synchronized int size() {
        return numbers.size();
    }
}
