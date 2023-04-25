package dk.via.exercise15_1;

import utility.collection.CircularLinkedList;
import utility.collection.DoubleLinkedList;
import utility.collection.LinearLinkedList;
import utility.collection.ListADT;

public class ThreadSafeLinkedList<T> implements ListADT<T> {
    public static int LINEAR_LINKED_LIST = 1;
    public static int CIRCULAR_LINKED_LIST = 2;
    public static int DOUBLE_LINKED_LIST = 3;
    private final ListADT<T> realSubject;

    private static <T> ListADT<T> createList(int type) {
        return switch (type) {
            case 1 -> new LinearLinkedList<>();
            case 2 -> new CircularLinkedList<>();
            case 3 -> new DoubleLinkedList<>();
            default -> throw new IllegalArgumentException("Unknown type");
        };
    }

    private ThreadSafeLinkedList(ListADT<T> realSubject) {
        this.realSubject = realSubject;
    }

    public ThreadSafeLinkedList(int type) {
        this(ThreadSafeLinkedList.createList(type));
    }

    @Override
    public synchronized void add(int index, T element) {
        realSubject.add(index, element);
    }

    @Override
    public synchronized void add(T element) {
          realSubject.add(element);
    }

    @Override
    public synchronized void set(int index, T element) {
        realSubject.set(index, element);
    }

    @Override
    public synchronized T get(int index) {
        return realSubject.get(index);
    }

    @Override
    public synchronized T remove(int index) {
        return realSubject.remove(index);
    }

    @Override
    public synchronized T remove(T element) {
        return realSubject.remove(element);
    }

    @Override
    public synchronized int indexOf(T element) {
        return realSubject.indexOf(element);
    }

    @Override
    public synchronized boolean contains(T element) {
        return realSubject.contains(element);
    }

    @Override
    public synchronized boolean isEmpty() {
        return realSubject.isEmpty();
    }

    @Override
    public synchronized boolean isFull() {
        return realSubject.isFull();
    }

    @Override
    public synchronized int size() {
        return realSubject.size();
    }
}
