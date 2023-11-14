public class PowerSet {

    private List<String> list;
    private int size;

    public PowerSet() {
        list = new ArrayList<>();
        size = 0;
    }

    public int size() {
        return size;
    }

    private int hashFun(String value) {
        int i = value.hashCode();
        return Math.abs(i % list.size());
    }

    public void put(String value) {
        if (list.contains(value)) return;
        int i = hashFun(value);
        if (list.get(i) == null) {
            list.add(i, value);
            size++;
            return;
        }
        int step = 3;
        for (int k = 0; k < list.size() / (step + 1); k++) {
            i = i + step >= list.size() ? (i + step) % list.size() : i + step;
            if (list.get(i) == null) {
                list.add(i, value);
                size++;
                return;
            }
        }
    }

    public boolean get(String value) {
        return list.contains(value);
    }

    public boolean remove(String value) {
        boolean removeResult = list.remove(value);
        if (removeResult) size--;
        return removeResult;
    }

    public PowerSet intersection(PowerSet set2) {
        PowerSet powerSet = new PowerSet();
        for (int i = 0; i < set2.list.size(); i++) {
            if (list.contains(set2.list.get(i))) powerSet.put(set2.list.get(i));
        }
        return powerSet;
    }

    public PowerSet union(PowerSet set2) {
        PowerSet powerSet = new PowerSet();
        for (int i = 0; i < set2.list.size(); i++) {
            put(set2.list.get(i));
        }
        return powerSet;
    }

    public PowerSet difference(PowerSet set2) {
        PowerSet powerSet = new PowerSet();
        for (int i = 0; i < list.size(); i++) {
            if (!set2.list.contains(list.get(i))) {
                powerSet.put(list.get(i));
            }
        }
        return powerSet;
    }

    public boolean isSubset(PowerSet set2) {
        for (int i = 0; i < set2.list.size(); i++) {
            if (!list.contains(set2.list.get(i))) return false;
        }
        return true;
    }
}