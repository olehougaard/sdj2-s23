package dk.via.exercise15_3;

public interface Buffer<T> {
    public void put(T element);
    public T take();
    public T look();
    public boolean isEmpty();
    public boolean isFull();
    public int size();
}
