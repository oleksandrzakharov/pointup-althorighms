package org.pointupit.alrorighms.trees;

import java.util.Iterator;

public interface Tree<T> extends Iterable<T> {

    Position<T> root();

    Position<T> parent(Position<T> parent) throws IllegalArgumentException;

    Iterable<Position<T>> children(Position<T> parent) throws IllegalArgumentException;

    long numChildren(Position<T> parent) throws IllegalArgumentException;

    boolean isInternal(Position<T> position) throws IllegalArgumentException;

    boolean isExternal(Position<T> position) throws IllegalArgumentException;

    boolean isRoot(Position<T> position) throws IllegalArgumentException;

    long size();

    boolean isEmpty();

    Iterator<T> iterator();

    Iterable<T> positions();
}
