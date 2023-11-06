public class HashTable {
    public int size;
    public int step;
    public String[] slots;

    public HashTable(int sz, int stp) {
        size = sz;
        step = stp;
        slots = new String[size];
        for (int i = 0; i < size; i++) slots[i] = null;
    }

    public int hashFun(String value) {
        int i = value.hashCode();
        return i % slots.length;
    }

    public int seekSlot(String value) {
        int i = hashFun(value);
        if (slots[i] == null) return i;
        int seekCycles = slots.length / step + 1;
        int counter = 0;
        while (slots[i] != null && counter < seekCycles) {
            i = i + step >= slots.length ? (i + step) % slots.length : i + step;
            if (slots[i] == null) return i;
        }
        return -1;
    }

    public int put(String value) {
        int i = seekSlot(value);
        if (i > -1) slots[i] = value;
        return i;
    }

    public int find(String value) {
        int i = hashFun(value);
        if (slots[i] != null && slots[i].equals(value)) return i;
        int seekCycles = slots.length / step + 1;
        int counter = 0;
        while (slots[i] != null && counter < seekCycles) {
            i = i + step >= slots.length ? (i + step) % slots.length : i + step;
            if (slots[i] != null && slots[i].equals(value)) return i;
        }
        return -1;
    }
}