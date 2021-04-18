package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApi {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        intList.add(3);
        intList.add(2);
        intList.add(-5);
        intList.add(6);
        intList.add(-10);
        intList.add(0);
        List<Integer> resList = intList.stream().filter(x -> x > 0).collect(Collectors.toList());
        System.out.println(resList);
    }
}
