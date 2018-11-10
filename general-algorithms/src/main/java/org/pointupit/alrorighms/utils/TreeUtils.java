package org.pointupit.alrorighms.utils;

public final class TreeUtils {

    public static <T> long countNonNullElements(T... elements) {
        long counter = 0;
        for (T element : elements) {
            if (element != null) {
                counter++;
            }
        }
        return counter;
    }
}
