package PowerSet;

public class Main {
    public static void main(String[] args) {
        PowerSet powerSet = new PowerSet();

        powerSet.put("Hello");
        powerSet.put("Hello3");

        powerSet.list.forEach((k,v) -> System.out.println(k));

        System.out.println(powerSet.get("Hello"));
        System.out.println(powerSet.get("Hello2"));
        System.out.println(powerSet.remove("Hello"));
        System.out.println(powerSet.get("Hello"));
    }
}
