package org.pointupit.alrorighms.trees;

import org.pointupit.alrorighms.utils.ValidatorUtils;

import java.util.Iterator;

public class LinkedBinaryTree<T> extends AbstractBinaryTree<T> {

    private TreeNode<T> root;
    private long size = 0;

    @Override
    public Position<T> left(Position<T> position) {
        return validate(position).getLeft();
    }

    @Override
    public Position<T> right(Position<T> position) {
        return validate(position).getRight();
    }

    @Override
    public Position<T> root() {
        return root;
    }

    @Override
    public Position<T> parent(Position<T> parent) {
        return validate(parent).getParent();
    }

    @Override
    public long size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Iterable<T> positions() {
        return null;
    }

    public Position<T> addRoot(T element) {
        if (!isEmpty()) {
            throw new IllegalArgumentException("The tree is not empty");
        }

        root = TreeNode.createTreeNode(element);
        size = 1;
        return root;
    }

    public Position<T> addLeft(T element, Position<T> parent) {
        final TreeNode<T> parentTreeNode = validate(parent);
        ValidatorUtils.requireNull(parentTreeNode.getLeft(), "The left child already exists");

        parentTreeNode.setLeft(TreeNode.createTreeNode(element, parentTreeNode, null, null));
        size++;

        return parentTreeNode.getLeft();
    }

    public Position<T> addRight(T element, Position<T> parent) {
        final TreeNode<T> parentTreeNode = validate(parent);
        ValidatorUtils.requireNull(parentTreeNode.getRight(), "The right child already exists");

        parentTreeNode.setRight(TreeNode.createTreeNode(element, parentTreeNode, null, null));
        size++;

        return parentTreeNode.getRight();
    }

    public T set(T element, Position<T> position) {
        final TreeNode<T> treeNode = validate(position);

        T previousElement = treeNode.getElement();
        treeNode.setElement(element);
        return previousElement;
    }

    public void attach(Position<T> position, LinkedBinaryTree<T> leftTree, LinkedBinaryTree<T> rightTree) {
        ValidatorUtils.requireNonNull(leftTree, rightTree);

        final TreeNode<T> treeNode = validate(position);

        if (isInternal(treeNode)) {
            throw new IllegalArgumentException("The position has children");
        }

        size += leftTree.size + rightTree.size;

        if (!leftTree.isEmpty()) {
            leftTree.root.setParent(treeNode);
            treeNode.setLeft(leftTree.root);
            leftTree.root = null;
            leftTree.size = 0;
        }

        if (!rightTree.isEmpty()) {
            rightTree.root.setParent(treeNode);
            treeNode.setRight(leftTree.root);
            rightTree.root = null;
            rightTree.size = 0;
        }
    }

    public T remove(Position<T> position) {
        final TreeNode<T> treeNode = validate(position);

        if (numChildren(position) == 2) {
            throw new IllegalArgumentException("The position has two children");
        }

        final TreeNode<T> childNode = ValidatorUtils
                .isNull(treeNode.getRight()) ? treeNode.getLeft() : treeNode.getRight();

        // TODO replace element
        return null;

    }

    private TreeNode<T> validate(Position<T> position) {
        ValidatorUtils.requireNonNull(position);

        if (!(position instanceof TreeNode)) {
            throw new IllegalArgumentException("The type of the position is not TreeNode");
        }

        final TreeNode<T> node = (TreeNode<T>) position;
        if (node.getParent() == node) {
            throw new IllegalArgumentException("There is a single position");
        }

        return node;
    }
}
