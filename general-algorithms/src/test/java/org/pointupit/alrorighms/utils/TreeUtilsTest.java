package org.pointupit.alrorighms.utils;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class TreeUtilsTest {

    @Test
    public void testCountNonNullElements() {
        // Given
        Object firstElement = new Object();
        Object secondObject = null;
        Object thirdObject = new Object();

        // When
        long counter = TreeUtils.countNonNullElements(firstElement, secondObject, thirdObject);

        // Then
        Assert.assertEquals(2, counter);

    }

}
