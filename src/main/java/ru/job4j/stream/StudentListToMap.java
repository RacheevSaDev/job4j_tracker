package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class StudentListToMap {
    Map<String, Student> toMap(List<Student> studentList) {
        return studentList.stream()
                .collect(Collectors
                        .toMap(Student::getSurname, student -> student, (x, y) -> y));
    }
}
