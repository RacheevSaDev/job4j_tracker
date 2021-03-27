package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        int i = 0;
        while (rsl == 0) {
            try {
                char leftChar = left.charAt(i);
                char rightChar = right.charAt(i);
                 rsl = Character.compare(leftChar, rightChar);
            } catch (IndexOutOfBoundsException e) {
                rsl = Integer.compare(left.length(), right.length());
                break;
            }
            i++;
        }
        return rsl;
    }
}