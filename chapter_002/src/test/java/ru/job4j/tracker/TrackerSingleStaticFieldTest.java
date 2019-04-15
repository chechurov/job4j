package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerSingleStaticFieldTest {
    @Test
    public void whenCreatedTwoObjectsAreEqual() {
        Tracker tracker1 = TrackerSingleStaticField.getInstance();
        Tracker tracker2 = TrackerSingleStaticField.getInstance();
        assertThat(tracker1 == tracker2, is(true));
    }
}