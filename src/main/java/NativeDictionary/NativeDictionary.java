package NativeDictionary;

import java.lang.reflect.Array;

class NativeDictionary<T> {
    public int size;
    public String[] slots;
    public T[] values;
    private int step;

    public NativeDictionary(int sz, Class clazz) {
        size = sz;
        if (sz <= 0) size = 1;
        slots = new String[size];
        step = 3;
        values = (T[]) Array.newInstance(clazz, this.size);
    }

    public int hashFun(String key) {
        int i = 0;
        if (key != null) {
            i = key.hashCode();
        }
        return Math.abs(i % slots.length);
    }

    public int seekSlot(String value) {
        int i = hashFun(value);
        if (slots[i] == null) return i;
        int seekCycles = slots.length / step + 1;
        int counter = 0;
        while (slots[i] != null && counter < seekCycles) {
            i = i + step >= slots.length ? (i + step) % slots.length : i + step;
            if (slots[i] == null) return i;
            counter++;
        }
        return -1;
    }

    public boolean isKey(String key) {
        if (key == null) {
            return false;
        }
        int i = hashFun(key);
        if (slots[i] != null && slots[i].equals(key)) return true;
        i = find(key);
        if (i == -1) return false;
        return slots[i] != null && slots[i].equals(key);
    }

    public void put(String key, T value) {
        int i = hashFun(key);
        if (slots[i] != null && slots[i].equals(key)) {
            values[i] = value;
        }
        if (slots[i] != null && !slots[i].equals(key)) {
            i = seekSlot(key);
            slots[i] = key;
            values[i] = value;
        }
        if (slots[i] == null) {
            slots[i] = key;
            values[i] = value;
        }
    }

    public T get(String key) {
        if (isKey(key)) {
            int i = find(key);
            return values[i];
        }
        return null;
    }

    private int find(String value) {
        int i = hashFun(value);
        if (slots[i] != null && slots[i].equals(value)) return i;
        int seekCycles = slots.length / step + 1;
        int counter = 0;
        while (slots[i] != null && counter < seekCycles) {
            i = i + step >= slots.length ? (i + step) % slots.length : i + step;
            if (slots[i] != null && slots[i].equals(value)) return i;
            counter++;
        }
        return -1;
    }
}