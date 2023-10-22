import java.util.*;

public class Deque<T> {
    private java.util.LinkedList<T> storage;
    public Deque() {
        storage = new java.util.LinkedList<>();
    }

    public void addFront(T item) {
        storage.addFirst(item);
    }

    public void addTail(T item) {
        storage.addLast(item);
    }

    public T removeFront() {
        if (storage.isEmpty()) return null;
        return storage.removeFirst();
    }

    public T removeTail() {
        if (storage.isEmpty()) return null;
        return storage.removeLast();
    }

    public int size() {
        return storage.size();
    }
}