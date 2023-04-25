package dk.via.exercise15_2;

import utility.collection.CircularLinkedList;
import utility.collection.ListADT;
import utility.collection.QueueADT;

public class QueueListBased<T> implements QueueADT<T> {
    private final ListADT<T> subject;

    public QueueListBased() {
        subject = new CircularLinkedList<>();
    }

    public void enqueue(T element) {
        subject.add(element);
    }

    public T dequeue() {
        return subject.remove(0);
    }

    public T first() {
        return subject.get(0);
    }

    public int indexOf(T element) {
        return subject.indexOf(element);
    }

    public boolean isEmpty() {
        return subject.isEmpty();
    }

    public boolean isFull() {
        return subject.isFull();
    }

    public int size() {
        return subject.size();
    }

    public int capacity() {
        return Integer.MAX_VALUE;
    }
}
