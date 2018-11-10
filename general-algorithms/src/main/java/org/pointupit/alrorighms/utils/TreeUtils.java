package org.pointupit.alrorighms.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class TreeUtils {

    @SafeVarargs
    public static <T> long countNonNullElements(T... elements) {
        ValidatorUtils.requireNotNull(elements);

        long counter = 0;
        for (T element : elements) {
            if (element != null) {
                counter++;
            }
        }
        return counter;
    }

    @SafeVarargs
    public static <T> List<T> concatNonNullElements(T... elements) {
        ValidatorUtils.requireNotNull(elements);

        final List<T> snapshot = new ArrayList<>(elements.length);
        for (T element : elements) {
            if (element != null) {
                snapshot.add(element);
            }
        }

        return Collections.unmodifiableList(snapshot);
    }
}
