package com.smartside.numfinder;

import org.junit.Before;
import org.junit.Test;

import static java.util.Collections.emptyList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class NumFinderTest {

    private NumFinder numFinder;

    @Before
    public void setUp() {
        this.numFinder = new NumFinder();
    }

    @Test
    public void emptyListShouldReturnZero() {
        assertThat(this.numFinder.find(emptyList()), is(0));
    }

}