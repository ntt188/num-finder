package com.smartside.numfinder;

import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

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

    @Test
    public void listContainsMinus274ShouldThrowExceptionWithMessageSpecifyingMinus274() {
        try {
            this.numFinder.find(singletonList(-274));
            fail("test failed");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is(equalTo("The number is not allowed: -274")));
        }
    }

    @Test
    public void listContainsMinus277ShouldThrowExceptionWithMessageSpecifyingMinus277() {
        try {
            this.numFinder.find(singletonList(-277));
            fail("test failed");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is(equalTo("The number is not allowed: -277")));
        }
    }

    @Test
    public void listContainsMinus273AndMinus277ShouldThrowExceptionWithMessageSpecifyingMinus277() {
        try {
            this.numFinder.find(asList(-273, -277));
            fail("test failed");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is(equalTo("The number is not allowed: -277")));
        }
    }

    @Test
    public void listContainsMinus273And100AndMinus277ShouldThrowExceptionWithMessageSpecifyingMinus277() {
        try {
            this.numFinder.find(asList(-273, 100, -277));
            fail("test failed");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is(equalTo("The number is not allowed: -277")));
        }
    }

    @Test
    public void listContains5527ShouldThrowExceptionWithMessageSpecifyingMinus5527() {
        try {
            this.numFinder.find(singletonList(5527));
            fail("test failed");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is(equalTo("The number is not allowed: 5527")));
        }
    }

    @Test
    public void listContains5526And5527ShouldThrowExceptionWithMessageSpecifyingMinus5527() {
        try {
            this.numFinder.find(asList(5526, 5527));
            fail("test failed");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is(equalTo("The number is not allowed: 5527")));
        }
    }

    @Test
    public void listContains100And5526And5527ShouldThrowExceptionWithMessageSpecifyingMinus5527() {
        try {
            this.numFinder.find(asList(100, 5526, 5527));
            fail("test failed");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is(equalTo("The number is not allowed: 5527")));
        }
    }

    @Test
    public void listContains100And5526AndMinus278And5527ShouldThrowExceptionWithMessageSpecifyingMinus278() {
        try {
            this.numFinder.find(asList(100, 5526, -278, 5527));
            fail("test failed");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is(equalTo("The number is not allowed: -278")));
        }
    }

    @Test
    public void listContains100And5526And5527AndMinus278ShouldThrowExceptionWithMessageSpecifyingMinus5527() {
        try {
            this.numFinder.find(asList(100, 5526, 5527, -278));
            fail("test failed");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is(equalTo("The number is not allowed: 5527")));
        }
    }

}