package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> combine = person -> key.equals(person.getName());
        combine = combine.or(
                person -> key.equals(person.getSurname())).or(
                        person -> key.equals(person.getPhone())).or(
                                person -> key.equals(person.getAddress()));
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}