package ru.job4j.tracker;

import java.time.LocalDate;

public class Builder extends  Engineer {
    private String name;
    private String surname;
    private String education;
    private LocalDate birthday;
    private String depart;
    private String specialisation;

    public Model construct(int type) {
        return new Model();
    }
}
