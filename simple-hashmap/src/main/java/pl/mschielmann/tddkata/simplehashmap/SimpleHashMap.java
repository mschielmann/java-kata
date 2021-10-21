package pl.mschielmann.tddkata.simplehashmap;

import java.util.ArrayList;
import java.util.List;

class SimpleHashMap
{

    private List<SimpleEntry> entries = new ArrayList<>();

    int size()
    {
        return entries.size();
    }

    void put(String key, String value)
    {
        if (key == null) {
            throw new NullPointerException("Key cannot be null.");
        }
        SimpleEntry entry = new SimpleEntry(key, value);
        entries.add(entry);
    }

    String get(String key)
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
        private final String key;
        private final String value;

        SimpleEntry(String key, String value)
        {
            this.key = key;
            this.value = value;
        }
    }
}
