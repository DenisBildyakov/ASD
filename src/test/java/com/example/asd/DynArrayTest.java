package com.example.asd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DynArrayTest {

    @Test
    void makeArray() {
        DynArray<String> da = new DynArray<>(String.class);
        Assertions.assertEquals(16, da.capacity);
        Assertions.assertEquals(16, da.array.length);
        Assertions.assertEquals(0, da.count);
    }

    @Test
    void getItem() {
        DynArray<String> da = new DynArray<>(String.class);
        da.append("Hello");
        assertEquals("Hello", da.getItem(0));
    }

    @Test
    void append() {
        DynArray<String> da = new DynArray<>(String.class);
        Assertions.assertEquals(16, da.capacity);
        Assertions.assertEquals(16, da.array.length);
        Assertions.assertEquals(0, da.count);
        da.append("Hello");
        Assertions.assertEquals(1, da.count);
    }

    @Test
    void append2() {
        DynArray<String> da = new DynArray<>(String.class);
        Assertions.assertEquals(16, da.capacity);
        Assertions.assertEquals(16, da.array.length);
        Assertions.assertEquals(0, da.count);
        for (int i = 0; i <= 16; i++) {
            da.append("Hello" + i);
            Assertions.assertEquals(i+1, da.count);
        }
        Assertions.assertEquals(32, da.capacity);
        Assertions.assertEquals(32, da.array.length);
    }

    @Test
    void insert() {
    }

    @Test
    void remove() {
        DynArray<String> da = new DynArray<>(String.class);
        Assertions.assertEquals(16, da.capacity);
        Assertions.assertEquals(16, da.array.length);
        Assertions.assertEquals(0, da.count);
        for (int i = 0; i < 32; i++) {
            da.append("Hello" + i);
            Assertions.assertEquals(i+1, da.count);
        }
        Assertions.assertEquals(32, da.capacity);
        Assertions.assertEquals(32, da.array.length);
        for (int i = da.count-1; i == 0; i--) {
            da.remove(i);
            Assertions.assertEquals(i+1, da.count);
            if (da.count < 16) {
                Assertions.assertEquals(16, da.capacity);
                Assertions.assertEquals(16, da.array.length);
            }
        }
    }
}