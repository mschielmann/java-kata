package pl.mschielmann.tddkata.recentlyusedlist;

import java.util.ArrayList;
import java.util.List;

class RecentlyUsedList
{
    private final List<String> list;
    private final int maxSize;

    public RecentlyUsedList(int maxSize)
    {
        this.maxSize = maxSize;
        list = new ArrayList<>(maxSize);
    }

    int size()
    {
        return list.size();
    }

    void add(String element)
    {
        list.remove(element);
        if (list.size() >= maxSize)
        {
            list.remove(maxSize - 1);
        }
        list.add(0, element);
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
