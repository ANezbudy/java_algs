package com.dtag.WFMTAT;

public class BalancedTreeElement {
    private int value;
    private BalancedTreeElement leftChildNode;
    private BalancedTreeElement rightChildNode;
    private BalancedTreeElement parentNode;
    private int sameCount;
    private int count;
    private int rightCount;
    private int leftCount;

    //constructor
    public BalancedTreeElement(int value) {
        this.value = value;
        setSameCount(1);

        setCount(1);

        setLeftCount(0);
        setRightCount(0);
    }

    /****************************************************************/
    // getters and setters
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public BalancedTreeElement getLeftChildNode() {
        return leftChildNode;
    }

    public void setLeftChildNode(BalancedTreeElement leftChildNode) {
        this.leftChildNode = leftChildNode;
    }

    public BalancedTreeElement getRightChildNode() {
        return rightChildNode;
    }

    public void setRightChildNode(BalancedTreeElement rightChildNode) {
        this.rightChildNode = rightChildNode;
    }

    public BalancedTreeElement getParentNode() {
        return parentNode;
    }

    public void setParentNode(BalancedTreeElement parentNode) {
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
    public BalancedTreeElement addNode(int value) {
        setCount(count + 1);
        if (value < getValue()) {
            if (getLeftChildNode() == null) {
                BalancedTreeElement childNode = new BalancedTreeElement(value);
                setLeftChildNode(childNode);
                getLeftChildNode().setParentNode(this);
                leftCount++;
            } else {
                leftChildNode = getLeftChildNode().addNode(value);
                leftCount = leftChildNode.getDepth();
            }
        } else if(value > getValue()) {
            if (getRightChildNode() == null) {
                BalancedTreeElement childNode = new BalancedTreeElement(value);
                setRightChildNode(childNode);
                getRightChildNode().setParentNode(this);
                rightCount++;
            } else  {
                rightChildNode = getRightChildNode().addNode(value);
                rightCount = rightChildNode.getDepth();
            }

        } else  if(value == getValue()) {
            sameCount++;
        }

        if ((rightCount - leftCount) > 1) {
            BalancedTreeElement tmpNode = leftChildNode;
            setLeftChildNode(tmpNode.rightChildNode);
            tmpNode.setRightChildNode(this);
            return tmpNode;
        } else if ((leftCount - rightCount) > 1) {
            BalancedTreeElement tmpNode = rightChildNode;
            setRightChildNode(tmpNode.leftChildNode);
            tmpNode.setLeftChildNode(this);
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



}
