package PowerSet;

public class Main {
    public static void main(String[] args) {
        PowerSet powerSet = new PowerSet();

        System.out.println(powerSet.remove("Heloo"));

        powerSet.put("Hello");
//        powerSet.put("Hello3");
//
//        powerSet.list.forEach((k,v) -> System.out.println(k));
//
        System.out.println(powerSet.get("Hello"));
        System.out.println(powerSet.get("Heloo"));
        System.out.println(powerSet.remove("Heloo"));
        System.out.println(powerSet.remove("Hello"));
//        System.out.println(powerSet.get("Hello"));
    }
}
