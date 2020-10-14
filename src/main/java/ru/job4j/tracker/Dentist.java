package ru.job4j.tracker;

import java.time.LocalDate;

public class Dentist extends  Doctor {
    private String name;
    private String surname;
    private String education;
    private LocalDate birthday;
    private String grade;
    private int yearsOfPractice;
    private boolean isManiac;

    public Pacient treatTooth(Pacient pacient) {
        return pacient;
    }

    public Pacient poolOutTooth(Pacient pacient) {
        return pacient;
    }
}
