package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        List<Address> res = profiles.stream().map(Profile::getAddress).collect(Collectors.toList());
        res.sort(Comparator.comparing(Address::getCity));
        return res.stream().distinct().collect(Collectors.toList());
    }
}
