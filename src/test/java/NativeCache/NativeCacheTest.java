package NativeCache;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

class NativeCacheTest {
    List<String> keys = List.of(
            "0123456789",
            "9012345678",
            "8901234567",
            "7890123456",
            "6789012345",
            "5678901234",
            "4567890123",
            "3456789012",
            "2345678901",
            "1234567890");

    @Test
    void isKey() {
        NativeCache<String> NativeCache = new NativeCache<String>(17, String.class);
        assertFalse(NativeCache.isKey("Hello"));
        NativeCache.put("Hello", "world");
        assertTrue(NativeCache.isKey("Hello"));

        NativeCache<String> NativeCache2 = new NativeCache<String>(0, String.class);
        assertFalse(NativeCache2.isKey("Hello"));
        NativeCache2.put("Hello", "world");
        assertTrue(NativeCache2.isKey("Hello"));

        NativeCache<String> NativeCache3 = new NativeCache<String>(2, String.class);
        assertFalse(NativeCache3.isKey("A"));
        assertFalse(NativeCache3.isKey("B"));
        NativeCache3.put("A", "a");
        assertTrue(NativeCache3.isKey("A"));
        assertFalse(NativeCache3.isKey("B"));
        NativeCache3.put("B", "b");
        assertTrue(NativeCache3.isKey("A"));
        assertTrue(NativeCache3.isKey("B"));

        assertFalse(NativeCache.isKey(null));
        assertFalse(NativeCache2.isKey(null));
        assertFalse(NativeCache3.isKey(null));

        NativeCache<String> NativeCache4 = new NativeCache<String>(17, String.class);
        for (int i = 0; i < 101; i++) {
            NativeCache4.put("A", "a");
        }
        assertTrue(NativeCache4.isKey("A"));
        assertFalse(NativeCache4.isKey("B"));

        NativeCache<String> NativeCache5 = new NativeCache<String>(17, String.class);
        for (int i = 0; i < NativeCache5.slots.length; i++) {
            NativeCache5.slots[i] = "A";
            NativeCache5.values[i] = "A";
        }
        assertTrue(NativeCache5.isKey("A"));
        assertFalse(NativeCache5.isKey("B"));

        NativeCache<String> NativeCache6 = new NativeCache<String>(17, String.class);
        char ch = 'A';
        for (int i = 0; i < NativeCache6.slots.length; i++) {
            NativeCache6.put(String.valueOf(ch), String.valueOf(ch));
            ch = (char) (ch + 1);
        }
        ch = 'A';
        for (int i = 0; i < NativeCache6.slots.length; i++) {
            assertTrue(NativeCache6.isKey(String.valueOf(ch)));
            ch = (char) (ch + 1);
        }
        assertTrue(NativeCache6.isKey("A"));
        assertFalse(NativeCache6.isKey("Hello"));

        String s = "0123456789", s1 = "1234567890";
        int v1 = 123456789;
        NativeCache<Integer> nd = new NativeCache<Integer>(97, Integer.class);
        for (int j = 0; j < 100; j++) nd.put(s, v1);
        assertTrue(nd.isKey(s));
        assertFalse(nd.isKey(s1));
    }

    @Test
    void put() {
        NativeCache<String> NativeCache = new NativeCache<String>(17, String.class);
        NativeCache.put("Hello", "world");
        assertEquals("world", NativeCache.get("Hello"));
        NativeCache.put("Hello", "everybody");
        assertEquals("everybody", NativeCache.get("Hello"));


        AtomicInteger i = new AtomicInteger();
        NativeCache<String> NativeCache2 = new NativeCache<String>(5, String.class);
        for (int l = 0; l < 5; l++) {
            NativeCache2.put(keys.get(l), String.valueOf(l));
        }
        for (int l = 0; l < 5; l++) {
            assertEquals(String.valueOf(l), NativeCache2.get(keys.get(l)));;
        }
        for (int l = 0; l < 5; l++) {
            NativeCache2.get(keys.get(0));
        }
        for (int l = 0; l < 4; l++) {
            NativeCache2.get(keys.get(1));
        }
        for (int l = 0; l < 3; l++) {
            NativeCache2.get(keys.get(2));
        }
        for (int l = 0; l < 2; l++) {
            NativeCache2.get(keys.get(3));
        }
        for (int l = 0; l < 1; l++) {
            NativeCache2.get(keys.get(4));
        }
        NativeCache2.put(keys.get(5), "666");
        assertEquals("666", NativeCache2.get(keys.get(5)));
        assertNull(NativeCache2.get(keys.get(0)));
    }

    @Test
    void get() {
        NativeCache<String> NativeCache = new NativeCache<String>(17, String.class);
        NativeCache.put("Hello", "world");
        assertEquals("world", NativeCache.get("Hello"));
        assertNull(NativeCache.get("Hi"));
    }
}