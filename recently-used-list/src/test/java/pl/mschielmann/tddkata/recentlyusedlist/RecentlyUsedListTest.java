package pl.mschielmann.tddkata.recentlyusedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecentlyUsedListTest
{
    @Test
    public void when_no_elements_added_list_is_empty()
    {
        RecentlyUsedList recentlyUsedList = new RecentlyUsedList();

        assertEquals(0, recentlyUsedList.size());
    }

    @Test
    public void when_one_element_added_size_is_1()
    {
        RecentlyUsedList recentlyUsedList = new RecentlyUsedList();
        recentlyUsedList.add("ElementOne");
        assertEquals(1, recentlyUsedList.size());
    }

    @Test
    public void when_one_element_added_it_is_first_on_the_list()
    {
        RecentlyUsedList recentlyUsedList = new RecentlyUsedList();
        recentlyUsedList.add("ElementOne");
        assertEquals("ElementOne", recentlyUsedList.getElement(0));
    }
}
