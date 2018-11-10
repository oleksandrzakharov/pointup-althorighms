package org.pointupit.alrorighms.trees;

public class EmptyPosition<T> implements Position<T> {

    @Override
    public T getElement() {
        throw new IllegalArgumentException("The position does not exist");
    }
}
