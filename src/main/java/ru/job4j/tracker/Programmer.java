package ru.job4j.tracker;

import java.time.LocalDate;

public class Programmer extends Engineer {
    private String name;
    private String surname;
    private String education;
    private LocalDate birthday;
    private String depart;
    private String projectName;
    private double kpi;

    public String writeCode(String code) {
        return code;
    }

    public String refactor(String code) {
        return code;
    }
}
