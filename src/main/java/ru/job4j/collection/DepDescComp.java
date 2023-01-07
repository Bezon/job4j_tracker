package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] path1 = o1.split("/");
        String[] path2 = o2.split("/");
        int rsl = path2[0].compareTo(path1[0]);
        for (int i = 1; i < Math.min(path1.length, path2.length); i++) {
            if (rsl == 0) {
                rsl = path1[i].compareTo(path2[i]);
            } else {
                break;
            }
        }
        if (rsl == 0) {
            rsl = Integer.compare(path1.length, path2.length);
        }
        return rsl;
    }
}