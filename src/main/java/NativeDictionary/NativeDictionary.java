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
        int i = key.hashCode();
        return i % slots.length;
    }

    public boolean isKey(String key) {
        int i = hashFun(key);
        if (slots[i] != null) return true;
        return false;
    }

    public void put(String key, T value) {
        int i = hashFun(key);
        slots[i] = key;
        values[i] = value;
    }

    public T get(String key) {
        if (isKey(key)) {
            int i = hashFun(key);
            return values[i];
        }
        return null;
    }
}