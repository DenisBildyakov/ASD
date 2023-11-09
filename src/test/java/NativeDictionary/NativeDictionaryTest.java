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