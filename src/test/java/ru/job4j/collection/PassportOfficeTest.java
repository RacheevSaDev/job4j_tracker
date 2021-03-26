package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PassportOfficeTest {

    @Test
    public void add() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }

    @Test
    public void addDouble() {
        Citizen citizen1 = new Citizen("2f44a", "Petr Arsentev");
        Citizen citizen2 = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office1 = new PassportOffice();
        office1.add(citizen1);
        office1.add(citizen2);
        PassportOffice office2 = new PassportOffice();
        office2.add(citizen1);
        assertThat(office1.getCitizens(), is(office2.getCitizens()));
    }
}