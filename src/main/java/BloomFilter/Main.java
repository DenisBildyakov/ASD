package BloomFilter;

public class Main {
    public static void main(String[] args) {
        BloomFilter bloomFilter = new BloomFilter(32);
        String s = "9012345678";
        String s2 = "8901234567";
        System.out.println(Integer.toBinaryString(0));
        System.out.println("------------");

        int filter1 = 0;
        int filter2 = 0;
        int i = bloomFilter.hash1(s);
        int k = bloomFilter.hash2(s);
        System.out.println("i = " + i);
        System.out.println("k = " + k);
        System.out.println("------------");

        filter1 |= (1<<i);
        filter2 |= (1<<k);

        System.out.println("Binary filter1 = " + Integer.toBinaryString(filter1));
        System.out.println("Binary filter2 = " + Integer.toBinaryString(filter2));
        System.out.println("------------");

        System.out.println("filter1 = " + filter1);
        System.out.println("filter2 = " + filter2);
        System.out.println("------------");
//
//
//        filter1 &= ~(1<<i);
//        filter2 &= ~(1<<k);
//        System.out.println(filter1);
//        System.out.println(filter2);
//        System.out.println("------------");

        System.out.println(filter1 & (2<<i));
        System.out.println(filter2 & (2<<k));
        System.out.println("------------");


        int i2 = bloomFilter.hash1(s2);
        int k2 = bloomFilter.hash2(s2);

        filter1 |= (1<<i2);
        filter2 |= (1<<k2);

        System.out.println("Binary filter1 = " + Integer.toBinaryString(filter1));
        System.out.println("Binary filter2 = " + Integer.toBinaryString(filter2));
        System.out.println("------------");

        System.out.println("filter1 = " + filter1);
        System.out.println("filter2 = " + filter2);
        System.out.println("------------");

        System.out.println(filter1 & (2<<i));
        System.out.println(filter2 & (2<<k));
        System.out.println("------------");
    }
}
