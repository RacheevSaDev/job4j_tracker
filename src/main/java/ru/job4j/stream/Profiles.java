package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        List<Address> res;
        res = profiles.stream().map(Profile::getAddress).collect(Collectors.toList());
        res.sort(Comparator.comparing(Address::getCity));
        res = res.stream().distinct().collect(Collectors.toList());
        return res;
    }
}
