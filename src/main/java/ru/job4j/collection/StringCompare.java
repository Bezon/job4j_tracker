package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = Integer.compare(left.length(), right.length());
        int index = rsl >= 0 ? left.length() : right.length();
        for (int i = 0; i < index; i++) {
            char one = i < left.length() ? left.charAt(i) : 0;
            char two = i < right.length() ? right.charAt(i) : 0;
            rsl = Character.compare(one, two);
            if (rsl != 0) {
                break;
            }
        }
        return rsl;
    }
}
