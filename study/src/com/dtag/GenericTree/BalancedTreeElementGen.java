package com.dtag.GenericTree;

import java.io.Serializable;

public class BalancedTreeElementGen<E extends Comparable<E> & Serializable> {
    private E value;

    private BalancedTreeElementGen leftChildNode;
    private BalancedTreeElementGen rightChildNode;
    private BalancedTreeElementGen parentNode;

    // counters
    private int sameCount;
    private int count;
    private int rightCount;
    private int leftCount;

    //constructor
    public BalancedTreeElementGen(E value) {
        this.value = value;
        setSameCount(1); // for what purpose

        setCount(1);

        setLeftCount(0);
        setRightCount(0);
    }

    /****************************************************************/
    // getters and setters
    public E getValue() {
        return value;
    }
    public void setValue(E value) {
        this.value = value;
    }

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }

    public BalancedTreeElementGen getLeftChildNode() {
        if (leftChildNode != null) {
            return leftChildNode;
        }
        return null;
    }
    public void setLeftChildNode(BalancedTreeElementGen leftChildNode) {
        this.leftChildNode = leftChildNode;
    }

    public BalancedTreeElementGen getRightChildNode() {
        if (rightChildNode != null) {
            return rightChildNode;
        }
        return null;
    }
    public void setRightChildNode(BalancedTreeElementGen rightChildNode) {
        this.rightChildNode = rightChildNode;
    }

    public BalancedTreeElementGen getParentNode() {
        return parentNode;
    }
    public void setParentNode(BalancedTreeElementGen parentNode) {
        this.parentNode = parentNode;
    }

    public void setRightCount(int rightCount) {
        this.rightCount = rightCount;
    }

    public void setLeftCount(int leftCount) {
        this.leftCount = leftCount;
    }

    public int getSameCount() {
        return sameCount;
    }

    public void setSameCount(int sameCount) {
        this.sameCount = sameCount;
    }


    /******************************************************************/

    // add node with count in right and left
    public BalancedTreeElementGen addNode(E value) {
        setCount(count + 1);
        // if value < getValue
        if (value.compareTo(getValue()) < 0) {
            if (leftChildNode == null) {
                leftChildNode = new BalancedTreeElementGen(value);
                leftCount = 1; // in Timer's variant leftCount = 1
            } else {
                leftChildNode = leftChildNode.addNode(value); // returns the element which become a root
                leftCount = leftChildNode.getDepth();
            }
        // if value > getValue
        } else if(value.compareTo(getValue()) > 0) {
            if (rightChildNode == null) {
                rightChildNode = new BalancedTreeElementGen(value);
                rightCount = 1;// in Timer's variant leftCount = 1
            } else  {
                rightChildNode = rightChildNode.addNode(value); // returns the element which become a root
                rightCount = rightChildNode.getDepth();
            }

        // if value == getValue
        } else  if(value.compareTo(getValue()) == 0) {
            sameCount++;
        }

        if ((rightCount - leftCount) > 1) {
            BalancedTreeElementGen tmpNode = rightChildNode;
            rightChildNode = tmpNode.leftChildNode;
            rightCount = tmpNode.leftCount;

            tmpNode.leftChildNode = this;
            tmpNode.leftCount = this.getDepth();

            return tmpNode;
        } else if ((leftCount - rightCount) > 1) {
            BalancedTreeElementGen tmpNode = leftChildNode;
            leftChildNode = tmpNode.rightChildNode;
            leftCount = tmpNode.rightCount;

            tmpNode.rightChildNode = this;
            tmpNode.rightCount = this.getDepth();

            return tmpNode;
        } else {
            return this;
        }

    }

    public void printTree() {

        if (this.getLeftChildNode() != null) {
            this.getLeftChildNode().printTree();
        }

        System.out.print(this.value + ", ");

        if(this.getRightChildNode() != null) {
            this.getRightChildNode().printTree();
        }
    }

    public void printLeft() {
        if (this.getLeftChildNode() != null) {
            this.getLeftChildNode().printLeft();
        }

        for (int i = 0; i < getSameCount(); i++) {
            System.out.print(this.value + ", ");
        }

        if (this.getRightChildNode() != null) {
            this.getRightChildNode().printLeft();
        }
    }

    public void printRight() {
        if (this.getRightChildNode() != null) {
            this.getRightChildNode().printRight();
        }

        for (int i = 0; i < getSameCount(); i++) {
            System.out.print(this.value + ", ");
        }

        if (this.getLeftChildNode() != null) {
            this.getLeftChildNode().printRight();
        }
    }

    // max depth
    public int getDepth() {
        return Math.max(leftCount, rightCount);
    }


    public void printWidth(int width) {


        // print left element
        BalancedTreeElementGen<E>[] allElementsOnLayer = new BalancedTreeElementGen[1];
        allElementsOnLayer[0] = this;
        boolean proceed = true;
        int i = 1;
        while (proceed) {
            proceed = false;
            BalancedTreeElementGen<E>[] allElementsOnNextLayer = new BalancedTreeElementGen[i*2];
            for (int j = 0; j < allElementsOnLayer.length; j++) {
                BalancedTreeElementGen<E> element = allElementsOnLayer[j];
                if (element != null) {
                    System.out.print(printAlign(width, element.value.toString())); //printed the current element

                    allElementsOnNextLayer[j*2] = element.leftChildNode;
                    allElementsOnNextLayer[j*2+1] = element.rightChildNode;

                    proceed = proceed || element.leftChildNode != null || element.rightChildNode != null;

                } else {
                    System.out.print(printAlign(width, ""));
                    allElementsOnNextLayer[j*2] = null;
                    allElementsOnNextLayer[j*2+1] = null;
                }
            }
            width = width/2;
            i = i*2;
            allElementsOnLayer = allElementsOnNextLayer;
            if (proceed) {
                System.out.println();
            }
        }
    }

    public static String printAlign(int width, String str) {
//        String str = value.toString();

        StringBuffer stringBuffer = new StringBuffer(width);
        Integer lengthOfSpaces = (width - str.length())/2;

        int i = 0;

        for (; i < lengthOfSpaces; i++) {
            stringBuffer.append(" ");
        }

        stringBuffer.append(str);
        i = i + str.length();

        for (; i < width; i++) {
            stringBuffer.append(" ");
        }

        return stringBuffer.toString();
    }

}
