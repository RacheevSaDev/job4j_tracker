package ru.job4j.collection;

        import org.junit.Test;
        import java.util.Comparator;
        import static org.hamcrest.Matchers.lessThan;
        import static org.junit.Assert.assertThat;

public class JobAscByNameTest {
    @Test
    public void whenCompatorByName() {
        Comparator<Job> cmpName = new JobAscByName();
        int rsl = cmpName.compare(
                new Job("A", 1),
                new Job("B", 0)
        );
        assertThat(rsl, lessThan(0));
    }
}