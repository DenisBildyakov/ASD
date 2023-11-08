package NativeDictionary;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        NativeDictionary<String> nativeDictionary = new NativeDictionary<String>(500, String.class);
//        System.out.println(nativeDictionary.slots.length);
//        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
//        System.out.println(arr.length);
//        System.out.println(nativeDictionary.isKey("Hello"));
//        nativeDictionary.put("Hello", "world");
//        System.out.println(nativeDictionary.isKey("Hello"));
//        System.out.println(nativeDictionary.get("Hello"));
        nativeDictionary.put("A", "a");
        nativeDictionary.put("B", "b");
        nativeDictionary.put("C", "c");
        nativeDictionary.put("D", "d");
        nativeDictionary.put("E", "e");
        nativeDictionary.put("F", "f");
        nativeDictionary.put("G", "g");
        nativeDictionary.put("J", "j");
        nativeDictionary.put("K", "k");
        nativeDictionary.put("L", "l");
        nativeDictionary.put("M", "m");
        nativeDictionary.put("N", "n");
        nativeDictionary.put("P", "p");
        nativeDictionary.put("Q", "q");
        nativeDictionary.put("R", "r");
        System.out.println(Arrays.toString(nativeDictionary.slots));
        System.out.println(Arrays.toString(nativeDictionary.values));
        System.out.println(nativeDictionary.isKey("A"));
        System.out.println(nativeDictionary.isKey("M"));
        System.out.println(nativeDictionary.isKey(null));

        char ch = 'A';
        for (int i = 0; i < 100; i++) {
            nativeDictionary.put(String.valueOf(ch), String.valueOf(ch));
            ch = (char) (ch + 1);
        }
        nativeDictionary.isKey("A");
        nativeDictionary.isKey("B");
        nativeDictionary.isKey("C");
        nativeDictionary.isKey("D");
        nativeDictionary.isKey("E");
        nativeDictionary.isKey("F");
        nativeDictionary.isKey("G");
        nativeDictionary.isKey("J");
        nativeDictionary.isKey("K");
        nativeDictionary.isKey("L");
        nativeDictionary.isKey("M");
        nativeDictionary.isKey("N");
        nativeDictionary.isKey("P");
        nativeDictionary.isKey("Q");
        nativeDictionary.isKey("R");
//        ch = 'A';
//        for (long i = 0; i < 50000000L; i++) {
////            System.out.println(nativeDictionary.isKey(String.valueOf(ch)));
//            nativeDictionary.isKey(String.valueOf(ch));
//            ch = (char) (ch + 1);
//        }
        System.out.println(nativeDictionary.isKey(null));

//        nativeDictionary.put("Hello", "mutherfucker");
//        System.out.println(nativeDictionary.isKey("Hello"));
//        System.out.println(nativeDictionary.isKey("AAA"));
//        System.out.println(nativeDictionary.get("Hello"));
        System.out.println(Arrays.toString(nativeDictionary.slots));
        System.out.println(Arrays.toString(nativeDictionary.values));
//        System.out.println(nativeDictionary.get("AAA"));

    }
}
