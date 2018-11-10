package org.pointupit.alrorighms.trees;

import org.pointupit.alrorighms.utils.ValidatorUtils;

public abstract class AbstractTree<T> implements Tree<T> {

    @Override
    public boolean isExternal(Position<T> position) {
        ValidatorUtils.requireNonNull(position);

        return numChildren(position) == 0;
    }

    @Override
    public boolean isInternal(Position<T> position) {
        ValidatorUtils.requireNonNull(position);

        return numChildren(position) > 0;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean isRoot(Position<T> position) {
        ValidatorUtils.requireNonNull(position);

        return position == root();
    }

    public long depth(Position<T> position) {
        ValidatorUtils.requireNonNull(position);

        if (isRoot(position)) {
            return 0L;
        } else {
            return 1 + depth(position);
        }
    }

    public long height(Position<T> position) {
        ValidatorUtils.requireNonNull(position);

        long h = 0;
        for (Position child : children(position)) {
            h = Math.max(h, 1 + height(child));
        }
        return h;
    }
}
