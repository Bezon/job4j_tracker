package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemSortByNameTest {

    @Test
    public void whenItemAscByName() {
        List<Item> items = Arrays.asList(new Item("3"), new Item("1"), new Item("2"));
        items.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(new Item("1"), new Item("2"), new Item("3"));
        assertThat(items.toString()).isEqualTo(expected.toString());
    }

    @Test
    public void whenItemDescByNam() {
        List<Item> items = Arrays.asList(new Item("a"), new Item("c"), new Item("b"));
        items.sort(new ItemDescByNam());
        List<Item> expected = Arrays.asList(new Item("c"), new Item("b"), new Item("a"));
        assertThat(items.toString()).isEqualTo(expected.toString());
    }
}