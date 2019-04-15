package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerSingleStaticFinalFieldTest {
    @Test
    public void whenCreatedTwoObjectsAreEqual() {
        Tracker tracker1 = TrackerSingleStaticFinalField.getInstance();
        Tracker tracker2 = TrackerSingleStaticFinalField.getInstance();
        assertThat(tracker1 == tracker2, is(true));
    }
}