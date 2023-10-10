package com.example.asd;

import java.lang.reflect.Array;

public class DynArray<T> {
    public T[] array;
    public int count;
    public int capacity;
    Class clazz;

    public DynArray(Class clz) {
        clazz = clz;
        count = 0;
        capacity = 16;
        makeArray(16);
    }

    public void makeArray(int new_capacity) {
        T[] tmp = array;
        array = (T[]) Array.newInstance(this.clazz, new_capacity);
        if (count > 0) {
            for (int i = 0; i < tmp.length; i++) {
                array[i] = tmp[i];
            }
        }
    }

    public T getItem(int index) {
        if (index < 0 || index > count - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return array[index];
    }

    public void append(T itm) {
        if (count == array.length) {
            capacity = capacity * 2;
            makeArray(capacity);
        }
        array[count] = itm;
        count++;
    }

    public void insert(T itm, int index) {
        if (index < 0 || index > count) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (count == array.length) {
            capacity = capacity * 2;
            makeArray(capacity);
        }
        for (int i = count; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = itm;
        count++;
    }

    public void remove(int index) {
        if (index < 0 || index > count) {
            throw new ArrayIndexOutOfBoundsException();
        }
        for (int i = index; i < count; i++) {
            array[i] = getItem(i + 1);
        }
        count--;
        if (count - 1 < capacity / 2) {
            capacity = (int) (capacity / 1.5);
            makeArray(capacity);
        }
    }

}