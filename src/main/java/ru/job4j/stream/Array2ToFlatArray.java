package ru.job4j.stream;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Array2ToFlatArray {

    ArrayList<Integer> convert(Integer[][] array2) {
        return (ArrayList<Integer>)
                Stream.of(array2).flatMap(Stream::of).collect(Collectors.toList());
    }
}
