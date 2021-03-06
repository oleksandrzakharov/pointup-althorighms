package org.pointupit.alrorighms.utils;

public final class ValidatorUtils {
    private ValidatorUtils() {
    }

    public static <T> void requireNonNull(T object) {
        if (object == null) {
            throw new IllegalArgumentException("Object is null");
        }
    }

    public static <T> void requireNull(T object, String message) {
        if (object != null) {
            throw new IllegalArgumentException(message);
        }
    }

    @SafeVarargs
    public static <T> void requireNonNull(T... objects) {
        if (objects == null) {
            throw new IllegalArgumentException("Array is null");
        }

        for (T object : objects) {
            if (object == null) {
                throw new IllegalArgumentException("The object si null");
            }
        }
    }

    public static <T> void requireNonNull(T object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }

    public static <T> boolean isNull(T object) {
        return object == null;
    }

    public static <T> boolean isNonNull(T object) {
        return object != null;
    }

}
