package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("mail@yadex.ru", "My email");
        for (String key : hashMap.keySet()) {
            System.out.println(key + " = " + hashMap.get(key));
        }
    }
}
