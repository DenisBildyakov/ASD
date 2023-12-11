package BloomFilter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BloomFilterTest {

    String s1 = "0123456789";
    String s2 = "9012345678";
    String s3 = "8901234567";
    String s4 = "7890123456";
    String s5 = "6789012345";
    String s6 = "5678901234";
    String s7 = "4567890123";
    String s8 = "3456789012";
    String s9 = "2345678901";
    String s10 = "1234567890";

    @Test
    void isValue() {
        BloomFilter bloomFilter = new BloomFilter(51);
        bloomFilter.add(s1);
        bloomFilter.add(s2);
        bloomFilter.add(s3);
        bloomFilter.add(s4);
        bloomFilter.add(s5);
        bloomFilter.add(s6);
        bloomFilter.add(s7);
        bloomFilter.add(s8);
        bloomFilter.add(s9);
        bloomFilter.add(s10);

        Assertions.assertTrue(bloomFilter.isValue(s1));
        Assertions.assertTrue(bloomFilter.isValue(s2));
        Assertions.assertTrue(bloomFilter.isValue(s3));
        Assertions.assertTrue(bloomFilter.isValue(s4));
        Assertions.assertTrue(bloomFilter.isValue(s5));
        Assertions.assertTrue(bloomFilter.isValue(s6));
        Assertions.assertTrue(bloomFilter.isValue(s7));
        Assertions.assertTrue(bloomFilter.isValue(s8));
        Assertions.assertTrue(bloomFilter.isValue(s9));
        Assertions.assertTrue(bloomFilter.isValue(s10));
    }
}