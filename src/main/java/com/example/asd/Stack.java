package com.example.asd;

import java.util.*;

public class Stack<T> {

    private java.util.LinkedList<T> stack;

    public Stack() {
        this.stack = new java.util.LinkedList<T>();
    }

    public int size() {
        return stack.size();
    }

    public T pop() {
        if (stack.isEmpty()) return null;
        return stack.removeLast();
    }

    public void push(T val) {
        stack.addLast(val);
    }

    public T peek() {
        if (stack.isEmpty()) return null;
        return stack.getLast();
    }
}