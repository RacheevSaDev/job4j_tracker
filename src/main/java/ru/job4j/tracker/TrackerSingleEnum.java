package ru.job4j.tracker;

import java.util.Arrays;

public enum TrackerSingleEnum {
    INSTANCE;

    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findByName(String key) {
        Item[] foundItems = new Item[this.size];
        int foundSize = 0;
        for (int i = 0; i < this.size; i++) {
            Item item = items[i];
            if (key.equals(item.getName())) {
                foundItems[foundSize++] = item;
            }
        }
        return Arrays.copyOf(foundItems, foundSize);
    }

    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.size);
    }

    public boolean replace(int id, Item item) {
        int replaceIndex = indexOf(id);
        if (replaceIndex != -1) {
            item.setId(id);
            this.items[replaceIndex] = item;
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            int start = index + 1;
            int length = size - index;
            System.arraycopy(this.items, start, this.items, index, length);
            this.items[size - 1] = null;
            size--;
            return true;
        }
        return false;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }
}
