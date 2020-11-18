package com.dtag.GenericTree;

import com.dtag.GenericTree.BalancedTreeElementGen;

public class BalancedBinaryTreeGen {
    private BalancedTreeElementGen root;

    public BalancedTreeElementGen getRoot() {
        return root;
    }

//    public void setRoot(BinaryTreeNode root) {
//        this.root = root;
//    }

    // constructor
    public BalancedBinaryTreeGen(int value) {
        root = new BalancedTreeElementGen(value);
    }


    public void add (int value) {
        root.addNode(value);
    }

    // methods to print tree
    /**********************************************/
    public void printBalancedTree() {
        root.printTree();
    }

    public void printBalancedTreeLeft() {
        root.printLeft();
    }

    public void printBalancedTreeRight() {
        root.printRight();
    }

    /*********************************************/




}
