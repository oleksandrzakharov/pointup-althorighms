package org.pointupit.alrorighms.trees;

public class TreeNode<T> implements Position<T> {

    private T e;
    private TreeNode<T> parent;
    private TreeNode<T> left;
    private TreeNode<T> right;

    private TreeNode(T e, TreeNode<T> parent, TreeNode<T> left, TreeNode<T> right) {
        this.e = e;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    public static <T> TreeNode<T> createTreeNode(T e, TreeNode<T> parent, TreeNode<T> left, TreeNode<T> right) {
        return new TreeNode<>(e, parent, left, right);
    }

    public static <T> TreeNode<T> createTreeNode(T e) {
        return new TreeNode<>(e, null, null, null);
    }

    @Override
    public T getElement() {
        return e;
    }

    public void setElement(T e) {
        this.e = e;
    }

    public TreeNode<T> getParent() {
        return parent;
    }

    public void setParent(TreeNode<T> parent) {
        this.parent = parent;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

}
