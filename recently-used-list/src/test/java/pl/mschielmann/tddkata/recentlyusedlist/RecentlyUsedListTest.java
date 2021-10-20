package pl.mschielmann.tddkata.recentlyusedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecentlyUsedListTest
{
    @Test
    public void when_no_elements_added_list_is_empty()
    {
        RecentlyUsedList recentlyUsedList = new RecentlyUsedList(1);

        assertEquals(0, recentlyUsedList.size());
    }

    @Test
    public void when_one_element_added_size_is_1()
    {
        RecentlyUsedList recentlyUsedList = new RecentlyUsedList(1);
        recentlyUsedList.add("ElementOne");
        assertEquals(1, recentlyUsedList.size());
    }

    @Test
    public void when_one_element_added_it_is_first_on_the_list()
    {
        RecentlyUsedList recentlyUsedList = new RecentlyUsedList(1);
        recentlyUsedList.add("ElementOne");
        assertEquals("ElementOne", recentlyUsedList.getElement(0));
    }

    @Test
    public void when_one_element_added_and_removed_then_list_is_empty()
    {
        RecentlyUsedList recentlyUsedList = new RecentlyUsedList(1);
        recentlyUsedList.add("ElementOne");
        recentlyUsedList.remove(0);
        assertEquals(0, recentlyUsedList.size());
    }

    @Test
    public void when_max_number_of_elements_added_then_all_are_in_the_list()
    {
        RecentlyUsedList recentlyUsedList = new RecentlyUsedList(5);
        recentlyUsedList.add("Element1");
        recentlyUsedList.add("Element2");
        recentlyUsedList.add("Element3");
        recentlyUsedList.add("Element4");
        recentlyUsedList.add("Element5");

        assertEquals(5, recentlyUsedList.size());
        assertEquals("Element1", recentlyUsedList.getElement(0));
        assertEquals("Element2", recentlyUsedList.getElement(1));
        assertEquals("Element3", recentlyUsedList.getElement(2));
        assertEquals("Element4", recentlyUsedList.getElement(3));
        assertEquals("Element5", recentlyUsedList.getElement(4));
    }
}
