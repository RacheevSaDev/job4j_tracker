package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int minSize = Integer.min(left.length(), right.length());
        for (int i = 0; i < minSize; i++) {
            int resCompare = Character.compare(left.charAt(i), right.charAt(i));
            if (resCompare != 0) {
                return (resCompare);
            }
        }
        return Integer.compare(left.length(), right.length());
    }
}