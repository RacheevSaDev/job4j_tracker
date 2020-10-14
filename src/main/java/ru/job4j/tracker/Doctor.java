package ru.job4j.tracker;

import java.time.LocalDate;

public class Doctor extends Profession {
    private String name;
    private String surname;
    private String education;
    private LocalDate birthday;
    private String grade;
    private int yearsOfPractice;

    public Diagnosis heal(Pacient pacient) {
        return new Diagnosis();
    }

}
