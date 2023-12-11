package Queue;

import java.util.LinkedList;

public class Queue<T> {
    private final LinkedList<T> storage;

    public Queue() {
        storage = new LinkedList<>();
    }

    public void enqueue(T item) {
        storage.addLast(item);
    }

    public T dequeue() {
        if (storage.isEmpty()) return null;
        return storage.removeFirst();
    }

    public int size() {
        return storage.size();
    }

    public void rotateFunction(int k) {
        for (int i = 0; i < k; i++) {
            if (!this.storage.isEmpty()) {
                enqueue(dequeue());
            }
        }
    }

}