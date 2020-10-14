package ru.job4j.tracker;

import java.time.LocalDate;

public class Surgeon extends Doctor {
    private String name;
    private String surname;
    private String education;
    private LocalDate birthday;
    private String grade;
    private int yearsOfPractice;
    private int type;
    private boolean isAnesthetist;

    public Pacient operate(Pacient pacient) {
        return pacient;
    }

    public Pacient amputate(Pacient pacient) {
        return pacient;
    }

}
