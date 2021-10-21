package pl.mschielmann.tddkata.simplehashmap;

class SimpleHashMap
{

    private int size = 0;

    int size()
    {
        return size;
    }

    void put(String key, String value)
    {
        size++;
    }
}
