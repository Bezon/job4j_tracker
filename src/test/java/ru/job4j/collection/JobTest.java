package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {
    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenJobAscByName() {
        Comparator<Job> cmpNamePriority = new JobAscByName();
        int rsl = cmpNamePriority.compare(
                new Job("Apple", 3),
                new Job("Bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenJobAscByPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByPriority();
        int rsl = cmpNamePriority.compare(
                new Job("Apple", 1),
                new Job("Bug", 3)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenJobDescByName() {
        Comparator<Job> cmpNamePriority = new JobDescByName();
        int rsl = cmpNamePriority.compare(
                new Job("Apple", 1),
                new Job("Bug", 3)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenJobDescByPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByPriority();
        int rsl = cmpNamePriority.compare(
                new Job("Apple", 1),
                new Job("Bug", 3)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenCompatorAscByNameAndDescByPrority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Apple", 0),
                new Job("Apple", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }
}