package org.pointupit.alrorighms.trees;

public interface BinaryTree<T> extends Tree<T> {

    Position<T> left(Position<T> position);

    Position<T> right(Position<T> position);

    Position<T> sibling(Position<T> position);
}
