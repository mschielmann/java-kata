package pl.mschielmann.tddkata.simplehashmap;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimpleHashMapTest
{
    @Test
    public void new_hashmap_has_size_of_0()
    {
        SimpleHashMap<String, String> hashMap = new SimpleHashMap<>();

        assertEquals(0, hashMap.size());
    }

    @Test
    public void when_one_entry_added_size_is_1()
    {
        SimpleHashMap<String, String> hashMap = new SimpleHashMap<>();

        hashMap.put("key1", "value1");

        assertEquals(1, hashMap.size());
    }

    @Test
    public void when_entry_added_it_can_be_retrieved_by_key()
    {
        SimpleHashMap<String, String> hashMap = new SimpleHashMap<>();

        hashMap.put("key1", "value1");

        assertEquals("value1", hashMap.get("key1"));
    }

    @Test
    public void when_null_key_added_then_npe_is_thrown()
    {
        SimpleHashMap<String, String> hashMap = new SimpleHashMap<>();

        assertThrows(NullPointerException.class, () -> hashMap.put(null, "value1"));
    }

    @Test
    public void when_entry_added_with_same_key_old_value_is_replaced()
    {
        SimpleHashMap<String, String> hashMap = new SimpleHashMap<>();

        hashMap.put("key1", "value1");
        hashMap.put("key2", "value2");
        hashMap.put("key3", "value3");
        hashMap.put("key2", "newValue2");

        assertEquals(3, hashMap.size());
        assertEquals("newValue2", hashMap.get("key2"));
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Test
    public void any_object_can_be_key()
    {
        SimpleHashMap hashMap = new SimpleHashMap();

        hashMap.put(1L, "value1");
        hashMap.put("key2", "value2");

        assertEquals(2, hashMap.size());
        assertEquals("value1", hashMap.get(1L));
        assertEquals("value2", hashMap.get("key2"));
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Test
    public void any_object_can_be_value()
    {
        SimpleHashMap hashMap = new SimpleHashMap();

        hashMap.put(1L, "value1");
        hashMap.put("key2", 2L);

        assertEquals(2, hashMap.size());
        assertEquals("value1", hashMap.get(1L));
        assertEquals(2L, hashMap.get("key2"));
    }

    @Test
    public void entry_can_be_removed_by_key()
    {
        SimpleHashMap<String, String> hashMap = new SimpleHashMap<>();

        hashMap.put("key1", "value1");
        hashMap.put("key2", "value2");
        hashMap.remove("key1");

        assertEquals(1, hashMap.size());
        assertNull(hashMap.get("key1"));
    }

    @Test
    public void assure_that_get_does_not_traverse_all_entries()
    {
        SimpleHashMap<TestObject, String> hashMap = new SimpleHashMap<>();
        TestObject key1 = new TestObject(1);
        TestObject key2 = new TestObject(2);
        TestObject key3 = new TestObject(3);

        hashMap.put(key1, "value1");
        hashMap.put(key2, "value2");
        hashMap.put(key3, "value3");
        hashMap.get(key2);

        assertFalse(key1.equalsWasInvoked);
        assertFalse(key3.equalsWasInvoked);
        assertTrue(key2.equalsWasInvoked);
    }

    @Test
    public void assure_that_same_hash_entries_can_be_stored() {
        SimpleHashMap<TestObject, String> hashMap = new SimpleHashMap<>();
        TestObject key1 = new TestObject(1);
        TestObject key2 = new TestObject(2);
        TestObject key3 = new TestObject(2);

        hashMap.put(key1, "value1");
        hashMap.put(key2, "value2");
        hashMap.put(key3, "value3");
        hashMap.get(key3);

        assertEquals(3, hashMap.size());
        assertFalse(key1.equalsWasInvoked);
        assertTrue(key2.equalsWasInvoked);
        assertTrue(key3.equalsWasInvoked);
    }

    static class TestObject
    {
        private final int hash;
        boolean equalsWasInvoked = false;

        TestObject(int hash)
        {
            this.hash = hash;
        }

        @Override
        public boolean equals(Object o)
        {
            equalsWasInvoked = true;
            return this == o;
        }

        @Override
        public int hashCode()
        {
            return Objects.hash(hash);
        }
    }
}
