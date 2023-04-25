package dk.via.queue;

import java.util.*;

public class ThreadSafeQueue<E> implements Queue<E> {
    private final ArrayDeque<E> elements;

    public ThreadSafeQueue() {
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
        return elements.add(e);
    }

    @Override
    public synchronized boolean remove(Object o) {
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
    public synchronized boolean offer(E e) {
        return elements.offer(e);
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
}
