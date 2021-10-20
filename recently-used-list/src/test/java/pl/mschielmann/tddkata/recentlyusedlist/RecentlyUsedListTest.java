package pl.mschielmann.tddkata.recentlyusedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecentlyUsedListTest
{
    @Test
    public void when_no_elements_added_list_is_empty() {
        RecentlyUsedList recentlyUsedList = new RecentlyUsedList();
        assertEquals(0, recentlyUsedList.size());
    }
}
