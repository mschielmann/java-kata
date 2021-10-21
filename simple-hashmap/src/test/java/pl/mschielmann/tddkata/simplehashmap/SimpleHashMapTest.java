package pl.mschielmann.tddkata.simplehashmap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SimpleHashMapTest
{
    @Test
    public void new_hashmap_has_size_of_0() {
        SimpleHashMap hashMap = new SimpleHashMap();

        assertEquals(0, hashMap.size());
    }

    @Test
    public void when_one_element_added_size_is_1() {
        SimpleHashMap hashMap = new SimpleHashMap();

        hashMap.put("key1", "value1");

        assertEquals(1, hashMap.size());
    }

    @Test
    public void when_element_added_it_can_be_retrieved_by_key() {
        SimpleHashMap hashMap = new SimpleHashMap();

        hashMap.put("key1", "value1");

        assertEquals("value1", hashMap.get("key1"));
    }

    @Test
    public void when_null_key_added_then_npe_is_thrown() {
        SimpleHashMap hashMap = new SimpleHashMap();

        assertThrows(NullPointerException.class, () -> hashMap.put(null, "value1"));
    }
}
