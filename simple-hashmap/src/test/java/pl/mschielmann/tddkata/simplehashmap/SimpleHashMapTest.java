package pl.mschielmann.tddkata.simplehashmap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleHashMapTest
{
    @Test
    public void new_hashmap_has_size_of_0() {
        SimpleHashMap hashMap = new SimpleHashMap();

        assertEquals(0, hashMap.size());
    }
}
