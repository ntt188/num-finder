package com.smartside.numfinder;

import java.util.List;
import java.util.stream.Collectors;

public class NumFinder {

    public Integer find(final List<Integer> numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        numbers.forEach(number -> {
            if (number < -273 || number > 5526) {
                throw new IllegalArgumentException("The number is not allowed: " + number);
            }
        });

        Integer minDistanceToZero = numbers.stream().mapToInt(num -> distanceToZero(num)).min().getAsInt();
        List<Integer> numbersClosestToZero = numbers.stream()
                .filter(num -> minDistanceToZero.equals(distanceToZero(num)))
                .distinct()
                .collect(Collectors.toList());

        if (numbersClosestToZero.size() == 1) {
            return numbersClosestToZero.get(0);
        }

        return numbersClosestToZero.stream().filter(num -> num > 0).findFirst().get();
    }

    private int distanceToZero(final Integer num) {
        return Math.abs(num);
    }
}
