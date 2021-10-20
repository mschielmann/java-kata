package pl.mschielmann.tddkata.recentlyusedlist;

import java.util.ArrayList;
import java.util.List;

class RecentlyUsedList
{
    private List<String> list = new ArrayList<>();

    int size()
    {
        return list.size();
    }

    void add(String element)
    {
        list.add(element);
    }

    public String getElement(int index)
    {
        return list.get(index);
    }
}
