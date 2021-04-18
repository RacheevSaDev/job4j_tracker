package ru.job4j.stream;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StudentListToMapTest {
    @Test
    public void convertToMapWithDoubles() {
        List<Student> students = List.of(
                new Student(10, "Surname1"),
                new Student(40, "Surname4"),
                new Student(50, "Surname5"),
                new Student(70, "Surname7"),
                new Student(10, "Surname1")
        );
        StudentListToMap studentListToMap = new StudentListToMap();
        Map<String, Student> rsl = studentListToMap.toMap(students);

        Map<String, Student> expected = new HashMap<>();
        expected.put("Surname1", new Student(10, "Surname1"));
        expected.put("Surname4", new Student(40, "Surname4"));
        expected.put("Surname5", new Student(50, "Surname5"));
        expected.put("Surname7", new Student(70, "Surname7"));

        assertThat(rsl, is(expected));
    }

}