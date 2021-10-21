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

    @Test
    public void when_element_added_with_same_key_old_value_is_replaced() {
        SimpleHashMap<String> hashMap = new SimpleHashMap<>();

        hashMap.put("key1", "value1");
        hashMap.put("key2", "value2");
        hashMap.put("key3", "value3");
        hashMap.put("key2", "newValue2");

        assertEquals(3, hashMap.size());
        assertEquals("newValue2", hashMap.get("key2"));
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Test
    public void any_object_can_be_key() {
        SimpleHashMap hashMap = new SimpleHashMap();

        hashMap.put(1L, "value1");
        hashMap.put("key2", "value2");

        assertEquals(2, hashMap.size());
        assertEquals("value1", hashMap.get(1L));
        assertEquals("value2", hashMap.get("key2"));
    }
}
