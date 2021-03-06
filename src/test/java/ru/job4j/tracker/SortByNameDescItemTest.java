package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortByNameDescItemTest {
    @Test
    public void sortByNameDescItem() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(1, "CFix bugs"));
        items.add(new Item(3, "DReboot server"));
        items.add(new Item(2, "AImpl task"));

        items.sort(new SortByNameDescItem());

        List<Item> expected = new ArrayList<>();
        expected.add(new Item(3, "DReboot server"));
        expected.add(new Item(1, "CFix bugs"));
        expected.add(new Item(2, "AImpl task"));

        Assert.assertEquals(items, expected);
    }
}