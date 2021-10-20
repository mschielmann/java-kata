package pl.mschielmann.tddkata.recentlyusedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecentlyUsedListTest
{

    @Test
    public void when_no_elements_added_list_is_empty()
    {
        int maxSize = 1;
        RecentlyUsedList recentlyUsedList = new RecentlyUsedList(maxSize);

        assertEquals(0, recentlyUsedList.size());
    }

    @Test
    public void when_one_element_added_size_is_1()
    {
        int maxSize = 1;
        RecentlyUsedList recentlyUsedList = new RecentlyUsedList(maxSize);

        recentlyUsedList.add("ElementOne");

        assertEquals(maxSize, recentlyUsedList.size());
    }

    @Test
    public void when_one_element_added_it_is_first_on_the_list()
    {
        int maxSize = 1;
        RecentlyUsedList recentlyUsedList = new RecentlyUsedList(maxSize);

        recentlyUsedList.add("ElementOne");

        assertEquals("ElementOne", recentlyUsedList.getElement(0));
    }

    @Test
    public void when_one_element_added_and_removed_then_list_is_empty()
    {
        int maxSize = 1;
        RecentlyUsedList recentlyUsedList = new RecentlyUsedList(maxSize);

        recentlyUsedList.add("ElementOne");
        recentlyUsedList.remove(0);

        assertEquals(0, recentlyUsedList.size());
    }

    @Test
    public void when_max_number_of_elements_added_then_all_are_in_the_list_in_opposite_order()
    {
        int maxSize = 5;
        RecentlyUsedList recentlyUsedList = new RecentlyUsedList(maxSize);

        recentlyUsedList.add("Element1");
        recentlyUsedList.add("Element2");
        recentlyUsedList.add("Element3");
        recentlyUsedList.add("Element4");
        recentlyUsedList.add("Element5");

        assertEquals(maxSize, recentlyUsedList.size());
        assertEquals("Element5", recentlyUsedList.getElement(0));
        assertEquals("Element4", recentlyUsedList.getElement(1));
        assertEquals("Element3", recentlyUsedList.getElement(2));
        assertEquals("Element2", recentlyUsedList.getElement(3));
        assertEquals("Element1", recentlyUsedList.getElement(4));
    }

    @Test
    public void when_more_than_max_number_of_elements_added_then_eldest_gets_removed()
    {
        int maxSize = 5;
        RecentlyUsedList recentlyUsedList = new RecentlyUsedList(maxSize);

        recentlyUsedList.add("Element1");
        recentlyUsedList.add("Element2");
        recentlyUsedList.add("Element3");
        recentlyUsedList.add("Element4");
        recentlyUsedList.add("Element5");
        recentlyUsedList.add("Element6");
        recentlyUsedList.add("Element7");

        assertEquals(maxSize, recentlyUsedList.size());
        assertEquals("Element7", recentlyUsedList.getElement(0));
        assertEquals("Element6", recentlyUsedList.getElement(1));
        assertEquals("Element5", recentlyUsedList.getElement(2));
        assertEquals("Element4", recentlyUsedList.getElement(3));
        assertEquals("Element3", recentlyUsedList.getElement(4));
    }

    @Test
    public void when_same_element_added_again_it_becomes_first_and_others_are_shifted()
    {
        int maxSize = 5;
        RecentlyUsedList recentlyUsedList = new RecentlyUsedList(maxSize);

        recentlyUsedList.add("Element1");
        recentlyUsedList.add("Element2");
        recentlyUsedList.add("Element3");
        recentlyUsedList.add("Element4");
        recentlyUsedList.add("Element2");

        assertEquals(4, recentlyUsedList.size());
        assertEquals("Element2", recentlyUsedList.getElement(0));
        assertEquals("Element4", recentlyUsedList.getElement(1));
        assertEquals("Element3", recentlyUsedList.getElement(2));
        assertEquals("Element1", recentlyUsedList.getElement(3));
    }
}
