package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerSingleStaticFinalClassTest {
    @Test
    public void whenCreatedTwoObjectsAreEqual() {
        Tracker tracker1 = TrackerSingleStaticFinalClass.getInstance();
        Tracker tracker2 = TrackerSingleStaticFinalClass.getInstance();
        assertThat(tracker1 == tracker2, is(true));
    }
}