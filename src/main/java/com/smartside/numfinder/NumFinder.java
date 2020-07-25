package com.smartside.numfinder;

import java.util.List;
import java.util.stream.Collectors;

public class NumFinder {

    private static final int ZERO_DISTANCE = 0;

    private final List<Number> numbers;

    public NumFinder(final List<Integer> numbers) {
        this.numbers = convertToNumberObjects(numbers);
    }

    private List<Number> convertToNumberObjects(List<Integer> numbers) {
        return numbers.stream()
                .map(this::toNumberObject)
                .collect(Collectors.toList());
    }

    private Number toNumberObject(Integer value) {
        return new Number(value);
    }

    public Integer find() {
        if (numbers.isEmpty()) {
            return ZERO_DISTANCE;

        } else {
            validateNumbers();
            Integer minDistanceToZero = findMinDistanceToZero();
            List<Number> numbersClosestToZero = findNumbersWithDistanceToZero(minDistanceToZero);

            Number selectedNumber = selectNumber(numbersClosestToZero);
            return selectedNumber.getValue();
        }
    }

    private void validateNumbers() {
        this.numbers.forEach(this::validateNumber);
    }

    private void validateNumber(Number number) {
        if (number.isInvalid()) {
            throw new IllegalArgumentException("The number is not allowed: " + number);
        }
    }

    private int findMinDistanceToZero() {
        return numbers.stream()
                .mapToInt(Number::distanceToZero)
                .min()
                .getAsInt();
    }

    private List<Number> findNumbersWithDistanceToZero(Integer distanceToZero) {
        return this.numbers.stream()
                .filter(num -> num.hasDistanceToZero(distanceToZero))
                .distinct()
                .collect(Collectors.toList());
    }

    private Number selectNumber(List<Number> numbersClosestToZero) {
        if (numbersClosestToZero.size() == 1) {
            return numbersClosestToZero.get(0);
        }

        return firstPositiveNumber(numbersClosestToZero);
    }

    private Number firstPositiveNumber(List<Number> numbers) {
        return numbers.stream()
                .filter(Number::isPositive)
                .findFirst()
                .get();
    }
}
