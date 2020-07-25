package com.smartside.numfinder;

import org.junit.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class NumFinderTest {

    @Test
    public void emptyListShouldReturnZero() {
        assertThat(new NumFinder(emptyList()).find(), is(0));
    }

    @Test
    public void listContainsMinus274ShouldThrowExceptionWithMessageSpecifyingMinus274() {
        try {
            new NumFinder(singletonList(-274)).find();
            fail("test failed");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is(equalTo("The number is not allowed: -274")));
        }
    }

    @Test
    public void listContainsMinus277ShouldThrowExceptionWithMessageSpecifyingMinus277() {
        try {
            new NumFinder(singletonList(-277)).find();
            fail("test failed");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is(equalTo("The number is not allowed: -277")));
        }
    }

    @Test
    public void listContainsMinus273AndMinus277ShouldThrowExceptionWithMessageSpecifyingMinus277() {
        try {
            new NumFinder(asList(-273, -277)).find();
            fail("test failed");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is(equalTo("The number is not allowed: -277")));
        }
    }

    @Test
    public void listContainsMinus273And100AndMinus277ShouldThrowExceptionWithMessageSpecifyingMinus277() {
        try {
            new NumFinder(asList(-273, 100, -277)).find();
            fail("test failed");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is(equalTo("The number is not allowed: -277")));
        }
    }

    @Test
    public void listContains5527ShouldThrowExceptionWithMessageSpecifyingMinus5527() {
        try {
            new NumFinder(singletonList(5527)).find();
            fail("test failed");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is(equalTo("The number is not allowed: 5527")));
        }
    }

    @Test
    public void listContains5526And5527ShouldThrowExceptionWithMessageSpecifyingMinus5527() {
        try {
            new NumFinder(asList(5526, 5527)).find();
            fail("test failed");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is(equalTo("The number is not allowed: 5527")));
        }
    }

    @Test
    public void listContains100And5526And5527ShouldThrowExceptionWithMessageSpecifyingMinus5527() {
        try {
            new NumFinder(asList(100, 5526, 5527)).find();
            fail("test failed");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is(equalTo("The number is not allowed: 5527")));
        }
    }

    @Test
    public void listContains100And5526AndMinus278And5527ShouldThrowExceptionWithMessageSpecifyingMinus278() {
        try {
            new NumFinder(asList(100, 5526, -278, 5527)).find();
            fail("test failed");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is(equalTo("The number is not allowed: -278")));
        }
    }

    @Test
    public void listContains100And5526And5527AndMinus278ShouldThrowExceptionWithMessageSpecifyingMinus5527() {
        try {
            new NumFinder(asList(100, 5526, 5527, -278)).find();
            fail("test failed");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is(equalTo("The number is not allowed: 5527")));
        }
    }

    @Test
    public void listContains0ShouldReturn0() {
        assertThat(new NumFinder(singletonList(0)).find(), is(0));
    }

    @Test
    public void listContains1ShouldReturn1() {
        assertThat(new NumFinder(singletonList(1)).find(), is(1));
    }

    @Test
    public void listContains2And1ShouldReturn1() {
        assertThat(new NumFinder(asList(2, 1)).find(), is(1));
    }

    @Test
    public void listContains2And1AndMinus5ShouldReturn1() {
        assertThat(new NumFinder(asList(2, 1, -5)).find(), is(1));
    }

    @Test
    public void listContains0And0ShouldReturn0() {
        assertThat(new NumFinder(asList(0, 0)).find(), is(0));
    }

    @Test
    public void listContains1And1ShouldReturn1() {
        assertThat(new NumFinder(asList(1, 1)).find(), is(1));
    }

    @Test
    public void listContains2And1AndMinus1ShouldReturn1() {
        assertThat(new NumFinder(asList(2, 1, -1)).find(), is(1));
    }

    @Test
    public void listContains2AndMinus1ShouldReturnMinus1() {
        assertThat(new NumFinder(asList(2, -1)).find(), is(-1));
    }
}