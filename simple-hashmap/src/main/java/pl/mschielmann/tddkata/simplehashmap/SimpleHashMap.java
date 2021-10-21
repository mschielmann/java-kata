package pl.mschielmann.tddkata.simplehashmap;

import java.util.ArrayList;
import java.util.List;

class SimpleHashMap<T>
{

    private final List<SimpleEntry> entries = new ArrayList<>();

    int size()
    {
        return entries.size();
    }

    void put(T key, String value)
    {
        if (key == null) {
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

        if (existingEntryForSameKey != null) {
            entries.remove(existingEntryForSameKey);
        }
        SimpleEntry newEntry = new SimpleEntry(key, value);
        entries.add(newEntry);
    }

    String get(T key)
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
        private final T key;
        private final String value;

        SimpleEntry(T key, String value)
        {
            this.key = key;
            this.value = value;
        }
    }
}
