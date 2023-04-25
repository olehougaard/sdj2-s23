package dk.via.exercise15_3;


import utility.collection.BoundedArrayQueue;
import utility.collection.QueueADT;

public class SynchronizedQueue<T> implements Buffer<T> {
    private final QueueADT<T> queue;

    public SynchronizedQueue(int capacity) {
        queue = new BoundedArrayQueue<>(capacity);
    }

    @Override
    public synchronized void put(T element) {
        queue.enqueue(element);
    }

    @Override
    public T take() {
        return queue.dequeue();
    }

    @Override
    public T look() {
        return queue.first();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public boolean isFull() {
        return queue.isFull();
    }

    @Override
    public int size() {
        return queue.size();
    }
}
