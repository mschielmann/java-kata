package pl.mschielmann.tddkata.simplehashmap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class SimpleHashMap<K, V>
{

    private final List<LinkedList<SimpleEntry>> buckets = new ArrayList<>();
    private final int numberOfBuckets = 16;
    private long elementsCount = 0L;

    SimpleHashMap()
    {
        for (int i = 0; i < numberOfBuckets; i++)
        {
            buckets.add(new LinkedList<>());
        }
    }

    long size()
    {
        return elementsCount;
    }

    void put(K key, V value)
    {
        if (key == null)
        {
            throw new NullPointerException("Key cannot be null.");
        }
        remove(key);

        LinkedList<SimpleEntry> bucket = buckets.get(key.hashCode() % numberOfBuckets);
        SimpleEntry newEntry = new SimpleEntry(key, value);
        bucket.add(newEntry);
        elementsCount++;
    }

    V get(K key)
    {
        LinkedList<SimpleEntry> bucketEntries = buckets.get(key.hashCode() % numberOfBuckets);
        for (SimpleEntry entry : bucketEntries)
        {
            if (entry.key.equals(key))
            {
                return entry.value;
            }
        }
        return null;
    }

    void remove(K key)
    {
        LinkedList<SimpleEntry> bucketEntries = buckets.get(key.hashCode() % numberOfBuckets);

        SimpleEntry existingEntryForSameKey = null;
        for (SimpleEntry entry : bucketEntries)
        {
            if (entry.key.equals(key))
            {
                existingEntryForSameKey = entry;
                break;
            }
        }

        if (existingEntryForSameKey != null)
        {
            bucketEntries.remove(existingEntryForSameKey);
            elementsCount--;
        }
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
