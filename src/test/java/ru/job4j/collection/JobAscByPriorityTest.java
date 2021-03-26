package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobAscByPriorityTest {
    @Test
    public void whenCompatorByPriority() {
        Comparator<Job> cmpPriority = new JobAscByPriority();
        int rsl = cmpPriority.compare(
                new Job("A", 0),
                new Job("B", 1)
        );
        assertThat(rsl, lessThan(0));
    }
}