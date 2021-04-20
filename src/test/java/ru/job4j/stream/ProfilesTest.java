package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {
    @Test
    public void whenCollectClassA() {
        Profiles profiles = new Profiles();
        Profile profile1 = new Profile(new Address("Novosibirsk", "Zolotodolinskaya", 13, 1));
        Profile profile2 = new Profile(new Address("Berdsk", "Molodosti", 2, 54));
        Profile profile3 = new Profile(new Address("Cuenca", "Av. Paseo de los Cañaris", 1, 601));
        Profile profile4 = new Profile(new Address("Novosibirsk", "Zolotodolinskaya", 13, 1));
        Profile profile5 = new Profile(new Address("Cuenca", "Av. Paseo de los Cañaris", 1, 601));
        List<Profile> profileList = List.of(profile1, profile2, profile3, profile4, profile5);
        List<Address> addressList = profiles.collect(profileList);

        List<Address> expected = List.of(
                new Address("Berdsk", "Molodosti", 2, 54),
                new Address("Cuenca", "Av. Paseo de los Cañaris", 1, 601),
                new Address("Novosibirsk", "Zolotodolinskaya", 13, 1));
        assertThat(addressList, is(expected));
    }
}