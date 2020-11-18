package com.dtag.WFMTAT;

public class BalancedBinaryTree {
    private BalancedTreeElement root;

    public BalancedTreeElement getRoot() {
        return root;
    }

//    public void setRoot(BinaryTreeNode root) {
//        this.root = root;
//    }

    public BalancedBinaryTree (int value) {
        root = new BalancedTreeElement(value);
    }

    public void add (int value) {
        root.addNode(value);
    }

    public void printBalancedTree() {
        root.printTree();
    }

    public void printBalancedTreeLeft() {
        root.printLeft();
    }

    public void printBalancedTreeRight() {
        root.printRight();
    }


}
