package com.smartside.numfinder;

import java.util.Objects;

class Number {

    private static final int LOWER_LIMIT = -273;
    private static final int UPPER_LIMIT = 5526;

    private final int value;

    Number(int value) {
        this.value = value;
    }

    Integer getValue() {
        return this.value;
    }

    boolean isInvalid() {
        return this.value < LOWER_LIMIT || this.value > UPPER_LIMIT;
    }

    Integer distanceToZero() {
        return Math.abs(value);
    }

    boolean hasDistanceToZero(Integer distanceToZero) {
        return this.distanceToZero().equals(distanceToZero);
    }

    boolean isPositive() {
        return this.value > 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
