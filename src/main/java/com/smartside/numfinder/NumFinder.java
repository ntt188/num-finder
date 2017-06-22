package com.smartside.numfinder;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.singletonList;

public class NumFinder {

    public List<Integer> find(final List<Integer> numbers) {
        if (numbers.isEmpty()) {
            return singletonList(0);
        }

        numbers.forEach(number -> {
            if (number < -273 || number > 5526) {
                throw new IllegalArgumentException("The number is not allowed: " + number);
            }
        });

        Integer minDistanceToZero = numbers.stream().mapToInt(num -> distanceToZero(num)).min().getAsInt();
        return numbers.stream().filter(num -> minDistanceToZero.equals(distanceToZero(num))).collect(Collectors.toList());
    }

    private int distanceToZero(final Integer num) {
        return Math.abs(num);
    }
}
