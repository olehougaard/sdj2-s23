package dk.via.queue;

import jdk.jshell.spi.ExecutionControl;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingThreadSafeQueue<E> implements BlockingQueue<E> {
    private final ArrayDeque<E> elements;
    private final int capacity;

    public BlockingThreadSafeQueue(int capacity) {
        this.capacity = capacity;
        this.elements = new ArrayDeque<>();
    }

    @Override
    public synchronized int size() {
        return elements.size();
    }

    @Override
    public synchronized boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public synchronized boolean contains(Object o) {
        return elements.contains(o);
    }

    @Override
    public int drainTo(Collection<? super E> c) {
        return drainTo(c, capacity);
    }

    @Override
    public int drainTo(Collection<? super E> c, int maxElements) {
        if (c == this) throw new IllegalArgumentException();
        ArrayList<E> drained = new ArrayList<>();
        if (size() > maxElements) {
            while(drained.size() < maxElements) {
                drained.add(elements.remove());
            }
        } else {
            drained.addAll(elements);
            elements.clear();
        }
        c.addAll(drained);
        return drained.size();
    }

    @Override
    public synchronized Iterator<E> iterator() {
        return elements.iterator();
    }

    @Override
    public synchronized Object[] toArray() {
        return elements.toArray();
    }

    @Override
    public synchronized <T1> T1[] toArray(T1[] a) {
        return elements.toArray(a);
    }

    @Override
    public synchronized boolean add(E e) {
        if (size() >= capacity) throw new IllegalStateException();
        return elements.add(e);
    }

    @Override
    public synchronized boolean remove(Object o) {
        if (isEmpty()) throw new IllegalStateException();
        return elements.remove(o);
    }

    @Override
    public synchronized boolean containsAll(Collection<?> c) {
        return elements.containsAll(c);
    }

    @Override
    public synchronized boolean addAll(Collection<? extends E> c) {
        return elements.addAll(c);
    }

    @Override
    public synchronized boolean removeAll(Collection<?> c) {
        return elements.removeAll(c);
    }

    @Override
    public synchronized boolean retainAll(Collection<?> c) {
        return elements.retainAll(c);
    }

    @Override
    public synchronized void clear() {
        elements.clear();
    }

    @Override
    public synchronized boolean offer(E t) {
        if (size() >= capacity) return false;
        return elements.add(t);
    }

    @Override
    public synchronized void put(E e) throws InterruptedException {
        while (size() >= capacity) {
            try {
                wait();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
        elements.add(e);
        notifyAll();
    }

    @Override
    public synchronized E take() throws InterruptedException {
        while(isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        E head = elements.remove();
        notifyAll();
        return head;
    }

    @Override
    public int remainingCapacity() {
        return capacity;
    }

    @Override
    public synchronized E remove() {
        return elements.remove();
    }

    @Override
    public synchronized E poll() {
        return elements.poll();
    }

    @Override
    public synchronized E element() {
        return elements.element();
    }

    @Override
    public synchronized E peek() {
        return elements.peek();
    }

    @Override
    public boolean offer(E e, long timeout, TimeUnit unit) {
        // Not implemented
        return false;
    }

    @Override
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        // Not implemented
        return null;
    }
}
