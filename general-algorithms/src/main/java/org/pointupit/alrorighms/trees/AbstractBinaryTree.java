package org.pointupit.alrorighms.trees;

import org.pointupit.alrorighms.utils.TreeUtils;
import org.pointupit.alrorighms.utils.ValidatorUtils;

public abstract class AbstractBinaryTree<T> extends AbstractTree<T> implements BinaryTree<T> {

    @Override
    public Position<T> sibling(Position<T> position) {
        ValidatorUtils.requireNonNull(position);

        final Position parent = parent(position);

        if (ValidatorUtils.isNonNull(parent)) {
            if (position == left(parent)) {
                return right(parent);
            } else {
                return left(parent);
            }
        } else {
            return new EmptyPosition();
        }
    }

    @Override
    public long numChildren(Position<T> parent) {
        ValidatorUtils.requireNonNull(parent);

        return TreeUtils.countNonNullElements(left(parent), right(parent));
    }

    @Override
    public Iterable<Position<T>> children(Position<T> parent) {
        ValidatorUtils.requireNonNull(parent);

        return TreeUtils.concatNonNullElements(left(parent), right(parent));
    }
}
