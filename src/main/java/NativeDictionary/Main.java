package NativeDictionary;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        NativeDictionary<String> nativeDictionary = new NativeDictionary<String>(10, String.class);

        String s = "0123456789" , s1 = "1234567890";
        int v1 = 123456789;
        NativeDictionary<Integer> nd = new NativeDictionary<Integer>(97, Integer.class);
        for(int j=0; j<100; j++) nd.put(s, v1);
        System.out.println(Arrays.toString(nativeDictionary.slots));
        System.out.println(Arrays.toString(nativeDictionary.values));
        nd.isKey(s1);


        System.out.println(Arrays.toString(nativeDictionary.slots));
        System.out.println(Arrays.toString(nativeDictionary.values));
//        System.out.println(nativeDictionary.get("AAA"));

    }
}
