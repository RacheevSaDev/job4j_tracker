package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> namePredicate = person -> key.contains(person.getName());
        Predicate<Person> surnamePredicate = person -> key.contains(person.getSurname());
        Predicate<Person> phonePredicate = person -> key.contains(person.getPhone());
        Predicate<Person> addressPredicate = person -> key.contains(person.getAddress());
        var  combine = namePredicate
                .or(surnamePredicate)
                .or(phonePredicate)
                .or(addressPredicate);
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}