public class BloomFilter {
    public int filter_len;

    private final byte[] filter1;

    private final byte[] filter2;

    public BloomFilter(int f_len) {
        filter_len = f_len;
        filter1 = new byte[filter_len];
        filter2 = new byte[filter_len];
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
        filter1[i] = 1;
        filter2[k] = 1;
    }

    public boolean isValue(String str1) {
        int i = hash1(str1);
        int k = hash2(str1);
        return filter1[i] == 1 && filter2[k] == 1;
    }
}