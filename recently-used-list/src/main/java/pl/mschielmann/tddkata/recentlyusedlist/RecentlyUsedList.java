package pl.mschielmann.tddkata.recentlyusedlist;

import java.util.ArrayList;
import java.util.List;

class RecentlyUsedList
{
    private final List<String> list;

    public RecentlyUsedList(int maxSize)
    {
        list = new ArrayList<>(maxSize);
    }

    int size()
    {
        return list.size();
    }

    void add(String element)
    {
        list.add(element);
    }

    String getElement(int index)
    {
        return list.get(index);
    }

    void remove(int index)
    {
        list.remove(index);
    }
}
