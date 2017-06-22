package com.smartside.numfinder;

import java.util.List;

public class NumFinder {

    public Integer find(final List<Integer> numbers) {

        numbers.forEach(number -> {
            if (number < -273 || number > 5526) {
                throw new IllegalArgumentException("The number is not allowed: " + number);
            }
        });

        return 0;
    }
}
