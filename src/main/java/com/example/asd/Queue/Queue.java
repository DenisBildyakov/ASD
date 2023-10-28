package com.example.asd.Queue;

import java.util.*;

public class Queue<T> {
    private java.util.LinkedList<T> storage;
    public Queue() {
        storage = new java.util.LinkedList<>();
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

}