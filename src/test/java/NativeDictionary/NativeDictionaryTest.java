package NativeDictionary;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NativeDictionaryTest {

    @Test
    void isKey() {
        NativeDictionary<String> nativeDictionary = new NativeDictionary<String>(17, String.class);
        assertFalse(nativeDictionary.isKey("Hello"));
        nativeDictionary.put("Hello", "world");
        assertTrue(nativeDictionary.isKey("Hello"));

        NativeDictionary<String> nativeDictionary2 = new NativeDictionary<String>(0, String.class);
        assertFalse(nativeDictionary2.isKey("Hello"));
        nativeDictionary2.put("Hello", "world");
        assertTrue(nativeDictionary2.isKey("Hello"));

        NativeDictionary<String> nativeDictionary3 = new NativeDictionary<String>(2, String.class);
        assertFalse(nativeDictionary3.isKey("A"));
        assertFalse(nativeDictionary3.isKey("B"));
        nativeDictionary3.put("A", "a");
        assertTrue(nativeDictionary3.isKey("A"));
        assertFalse(nativeDictionary3.isKey("B"));
        nativeDictionary3.put("B", "b");
        assertTrue(nativeDictionary3.isKey("A"));
        assertTrue(nativeDictionary3.isKey("B"));

        assertFalse(nativeDictionary.isKey(null));
        assertFalse(nativeDictionary2.isKey(null));
        assertFalse(nativeDictionary3.isKey(null));

        NativeDictionary<String> nativeDictionary4 = new NativeDictionary<String>(17, String.class);
        for (int i = 0; i < 101; i++) {
            nativeDictionary4.put("A", "a");
        }
        assertTrue(nativeDictionary4.isKey("A"));
        assertFalse(nativeDictionary4.isKey("B"));

        NativeDictionary<String> nativeDictionary5 = new NativeDictionary<String>(17, String.class);
        for (int i = 0; i < nativeDictionary5.slots.length; i++) {
            nativeDictionary5.slots[i] = "A";
            nativeDictionary5.values[i] = "A";
        }
        assertTrue(nativeDictionary5.isKey("A"));
        assertFalse(nativeDictionary5.isKey("B"));

        NativeDictionary<String> nativeDictionary6 = new NativeDictionary<String>(17, String.class);
        char ch = 'A';
        for (int i = 0; i < nativeDictionary6.slots.length; i++) {
            nativeDictionary6.put(String.valueOf(ch), String.valueOf(ch));
            ch = (char) (ch + 1);
        }
        ch = 'A';
        for (int i = 0; i < nativeDictionary6.slots.length; i++) {
            assertTrue(nativeDictionary6.isKey(String.valueOf(ch)));
            ch = (char) (ch + 1);
        }
        assertTrue(nativeDictionary6.isKey("A"));
        assertFalse(nativeDictionary6.isKey("Hello"));
    }

    @Test
    void put() {
        NativeDictionary<String> nativeDictionary = new NativeDictionary<String>(17, String.class);
        nativeDictionary.put("Hello", "world");
        assertEquals("world", nativeDictionary.get("Hello"));
        nativeDictionary.put("Hello", "everybody");
        assertEquals("everybody", nativeDictionary.get("Hello"));
    }

    @Test
    void get() {
        NativeDictionary<String> nativeDictionary = new NativeDictionary<String>(17, String.class);
        nativeDictionary.put("Hello", "world");
        assertEquals("world", nativeDictionary.get("Hello"));
        assertNull(nativeDictionary.get("Hi"));
    }
}