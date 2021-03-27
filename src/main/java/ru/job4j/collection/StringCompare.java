package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {

        int leftSize = left.length();
        int rightSize = right.length();
        int minSize = Integer.min(leftSize, rightSize);
        for (int i = 0; i < minSize; i++) {
            char leftChar = left.charAt(i);
            char rightChar = right.charAt(i);
            int resCompare = Character.compare(leftChar, rightChar);
            if (resCompare != 0) {
                return (resCompare);
            }
        }
        return Integer.compare(leftSize, rightSize);
    }
}