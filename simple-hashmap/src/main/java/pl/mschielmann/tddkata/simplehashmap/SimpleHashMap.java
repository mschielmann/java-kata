package pl.mschielmann.tddkata.simplehashmap;

import java.util.ArrayList;
import java.util.List;

class SimpleHashMap<K, V>
{

    private final List<SimpleEntry> entries = new ArrayList<>();

    int size()
    {
        return entries.size();
    }

    void put(K key, V value)
    {
        if (key == null)
        {
            throw new NullPointerException("Key cannot be null.");
        }
        SimpleEntry existingEntryForSameKey = null;
        for (SimpleEntry entry : entries)
        {
            if (entry.key.equals(key))
            {
                existingEntryForSameKey = entry;
                break;
            }
        }

        if (existingEntryForSameKey != null)
        {
            entries.remove(existingEntryForSameKey);
        }
        SimpleEntry newEntry = new SimpleEntry(key, value);
        entries.add(newEntry);
    }

    V get(K key)
    {
        for (SimpleEntry entry : entries)
        {
            if (entry.key.equals(key))
            {
                return entry.value;
            }
        }
        return null;
    }

    class SimpleEntry
    {
        private final K key;
        private final V value;

        SimpleEntry(K key, V value)
        {
            this.key = key;
            this.value = value;
        }
    }
}
