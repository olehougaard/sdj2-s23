package dk.via.exercise13_4;

import java.util.ArrayList;
import java.util.List;

public class TodoList {
    private final List<String> unfinished;
    private final List<String> finished;

    public TodoList() {
        unfinished = new ArrayList<>();
        finished = new ArrayList<>();
    }

    public boolean isAllDone() {
        return unfinished.isEmpty();
    }

    public int unfinishedCount() {
        return unfinished.size();
    }

    public int finishedCount() {
        return finished.size();
    }

    public boolean isEmpty() {
        return unfinished.isEmpty() && finished.isEmpty();
    }

    public void add(String todo) {
        this.unfinished.add(todo);
    }

    public String getUnfinished(int index) {
        if (index < 0 || index >= unfinished.size()) {
            throw new IllegalArgumentException("Unknown todo: " + index);
        }
        return unfinished.get(index);
    }

    public String getFinished(int index) {
        if (index < 0 || index >= finished.size()) {
            throw new IllegalArgumentException("Unknown todo: " + index);
        }
        return finished.get(index);
    }

    public void finish(int index) {
        if (index < 0 || index >= unfinished.size()) {
            throw new IllegalArgumentException("Unknown todo: " + index);
        }
        String removed = unfinished.remove(index);
        finished.add(removed);
    }
}
