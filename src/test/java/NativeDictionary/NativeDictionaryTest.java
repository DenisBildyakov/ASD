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