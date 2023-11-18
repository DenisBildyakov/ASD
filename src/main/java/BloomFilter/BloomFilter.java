public class BloomFilter {
    public int filter_len;
    private int filter1;
    private int filter2;

    public BloomFilter(int f_len) {
        filter_len = f_len;
        filter1 = 0;
        filter2 = 0;
    }

    private int iteration(String value, int randomNumber) {
        int iter = 0;
        for (int i = 0; i < value.length(); i++) {
            int code = (int) value.charAt(i);
            iter = iter * randomNumber + code;
        }
        return iter;
    }

    public int hash1(String str1) {
        int randomNumber = 17;
        int iter = iteration(str1, randomNumber);
        return Math.abs(iter % filter_len);
    }

    public int hash2(String str1) {
        int randomNumber = 223;
        int iter = iteration(str1, randomNumber);
        return Math.abs(iter % filter_len);
    }

    public void add(String str1) {
        int i = hash1(str1);
        int k = hash2(str1);
        filter1 |= (1 << i);
        filter2 |= (1 << k);
    }

    public boolean isValue(String str1) {
        int i = hash1(str1);
        int k = hash2(str1);
        return (filter1 & (1 << i)) == (1 << i) && (filter2 & (1 << k)) == (1 << k);
    }
}