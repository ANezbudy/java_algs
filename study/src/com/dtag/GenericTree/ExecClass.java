package com.dtag.GenericTree;

public class ExecClass {
    public static void main (String[] args) {

        BalancedTreeElementGen node = new BalancedTreeElementGen(15);
        node.addNode(10);
        node.addNode(20);
        node.addNode(25);
        node.addNode(7);
        node.addNode(5);
        node.addNode(13);
        node.addNode(1);
        node.addNode(10);
        node.addNode(15);
        node.addNode(4);
        node.addNode(14);
        node.addNode(15);
        node.addNode(13);

        node.printWidth(128);
        // протестить печать

        Screen.drawTree(node);

    }
}
