package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

public class Array2ToFlatArrayTest {
    @Test
    public void convertArray2x2ToFlatList() {
        Integer[][] array2 = new Integer[2][2];
        array2[0][0] = 1;
        array2[0][1] = 2;
        array2[1][0] = 3;
        array2[1][1] = 4;
        Array2ToFlatArray array2ToFlatArray = new Array2ToFlatArray();
        List<Integer> expected = List.of(1, 2, 3, 4);
        assertThat(array2ToFlatArray.convert(array2), is(expected));
    }
}