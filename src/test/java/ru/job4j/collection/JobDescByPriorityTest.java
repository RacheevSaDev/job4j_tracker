package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobDescByPriorityTest {
    @Test
    public void whenCompatorByPriority() {
        Comparator<Job> cmpPriority = new JobDescByPriority();
        int rsl = cmpPriority.compare(
                new Job("A", 1),
                new Job("B", 0)
        );
        assertThat(rsl, lessThan(0));
    }
}