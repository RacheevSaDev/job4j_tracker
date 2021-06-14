package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] o1Split = o1.split("/");
        String[] o2Split = o2.split("/");
        if (o1Split[0].equals(o2Split[0])) {
            if (o1Split.length == o2Split.length) {
                for (int i = 1; i < o1Split.length; i++) {
                    int rsl = o1Split[i].compareTo(o2Split[i]);
                    if (rsl != 0) {
                        return rsl;
                    }
                }
            } else {
                return Integer.compare(o1Split.length, o2Split.length);
            }
        } else {
            return o2Split[0].compareTo(o1Split[0]);
        }
        return 0;
    }
}
