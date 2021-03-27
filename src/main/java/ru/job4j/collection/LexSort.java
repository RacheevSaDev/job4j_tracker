package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftStrings = left.split("\\.", 2);
        String[] rightStrings = right.split("\\.", 2);
        int leftNum = Integer.parseInt(leftStrings[0]);
        int rightNum = Integer.parseInt(rightStrings[0]);
        return Integer.compare(leftNum, rightNum);
    }
}