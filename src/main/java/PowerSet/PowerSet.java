public class PowerSet {

    public HashMap<String, String> list;

    public PowerSet() {
        list = new HashMap<>();
    }

    public int size() {
        return list.size();
    }

    public void put(String value) {
        list.computeIfAbsent(value, v -> "null");
    }

    public boolean get(String value) {
        return list.containsKey(value);
    }

    public boolean remove(String value) {
        String s = list.remove(value);
        return !list.containsKey(value);
    }

    public PowerSet intersection(PowerSet set2) {
        PowerSet powerSet = new PowerSet();
        list.entrySet().stream()
                .filter(entry -> set2.list.containsKey(entry.getKey()))
                .forEach(k -> powerSet.put(k.getKey()));
        return powerSet;
    }

    public PowerSet union(PowerSet set2) {
        PowerSet powerSet = new PowerSet();
        this.list.forEach((k, v) -> powerSet.put(k));
        set2.list.forEach((k, v) -> powerSet.put(k));
        return powerSet;
    }

    public PowerSet difference(PowerSet set2) {
        PowerSet powerSet = new PowerSet();
        this.list.entrySet().stream()
                .filter(entry -> !set2.list.containsKey(entry.getKey()))
                .forEach(entry -> powerSet.put(entry.getKey()));
        return powerSet;
    }

    public boolean isSubset(PowerSet set2) {
        return set2.list.keySet().stream().allMatch(k -> this.list.containsKey(k));
    }
}