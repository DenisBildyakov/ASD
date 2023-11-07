package NativeDictionary;

import java.lang.reflect.Array;

class NativeDictionary<T> {
    public int size;
    public String[] slots;
    public T[] values;

    public NativeDictionary(int sz, Class clazz) {
        size = sz;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
    }

    public int hashFun(String key) {
        int i = 0;
        if (key != null) i = key.hashCode();
        return i % slots.length;
    }

    public boolean isKey(String key) {
        if (key == null) return false;
        int i = hashFun(key);
        return slots[i] != null && slots[i].equals(key);
    }

    public void put(String key, T value) {
        int i = hashFun(key);
        if (slots[i] == null) {
            slots[i] = key;
            values[i] = value;
        }
        if (slots[i] != null && slots[i].equals(key)) {
            values[i] = value;
        }
    }

    public T get(String key) {
        if (isKey(key)) {
            int i = hashFun(key);
            return values[i];
        }
        return null;
    }
}