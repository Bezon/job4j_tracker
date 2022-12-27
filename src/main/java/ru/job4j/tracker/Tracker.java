package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(size++, item);
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findAll() {
        return items;
    }

    public Item[] findByName(String name) {
        Item[] rsl = new Item[size];
        int counter = 0;
        for (int index = 0; index < size; index++) {
            Item item = items.get(index);
            if (name.equals(item.getName())) {
                rsl[counter] = item;
                counter++;
            }
        }
        rsl = Arrays.copyOf(rsl, counter);
        return rsl;
    }

    private int indexOf(int id) {
        int rsl = -1;
        if (items.size() > 0) {
            for (int index = 0; index < size; index++) {
                if (items.get(index).getId() == id) {
                    rsl = index;
                    break;
                }
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            items.set(index, item);
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            items.remove(index);
        }
        return rsl;
    }
}