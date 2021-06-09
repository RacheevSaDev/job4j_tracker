package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Array2ToFlatArray {

    public List<Integer> convert(Integer[][] array2) {
        return Stream.of(array2).flatMap(Stream::of).collect(Collectors.toList());
    }
}
