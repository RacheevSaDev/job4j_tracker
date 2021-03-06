package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findByName(String key) {
        List<Item> foundItems = new ArrayList<>();
        for (Item item: items) {
            if (key.equals(item.getName())) {
                foundItems.add(item);
            }
        }
        return foundItems;
    }

    public List<Item> findAll() {
        return items;
    }

    public boolean replace(int id, Item item) {
        int replaceIndex = indexOf(id);
        if (replaceIndex != -1) {
            item.setId(id);
            items.set(replaceIndex, item);
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            items.remove(index);
            return true;
        }
        return false;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int i = 0; i < items.size(); i++) {
            Item selectedItem = items.get(i);
            if (selectedItem.getId() == id) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }
}