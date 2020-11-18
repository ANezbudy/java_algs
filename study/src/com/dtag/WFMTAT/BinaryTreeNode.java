package com.dtag.WFMTAT;

import java.util.ArrayList;

public class BinaryTreeNode {
    private int value;
    private BinaryTreeNode leftChildNode;
    private BinaryTreeNode rightChildNode;
    private BinaryTreeNode parentNode;
    private int count;
    private int rightCount = 0;
    private int leftCount = 0;

    //constructor
    public BinaryTreeNode(int value) {
        this.value = value;
        this.setCount(1);
//        this.setRightCount(1);
//        this.setLeftCount(1);
    }

//    public BinaryTreeNode(int value, int index) {
//        this.value = value;
//        this.count = index;
//    }

    public int getValue () {
        return this.value;
    }

    public BinaryTreeNode getLeftChildNode() {
        return this.leftChildNode;
    }

    public BinaryTreeNode getRightChildNode() {
        return this.rightChildNode;
    }

    public void setValue(int value) {
        this.value = value;
    }

    private void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return this.count;
    }

    private void setLeftChildNode(BinaryTreeNode leftChildNode) {
        this.leftChildNode = leftChildNode;
    }

    private void setRightChildNode(BinaryTreeNode rightChildNode) {
        this.rightChildNode = rightChildNode;
    }

    public int getRightCount() {
        return rightCount;
    }

    public void setRightCount(int rightCount) {
        this.rightCount = rightCount;
    }

    public int getLeftCount() {
        return leftCount;
    }

    public void setLeftCount(int leftCount) {
        this.leftCount = leftCount;
    }

    public BinaryTreeNode getParentNode() {
        return parentNode;
    }

    public void setParentNode(BinaryTreeNode parentNode) {
        this.parentNode = parentNode;
    }

    public void addNode (int value) {

        if (value <= getValue()) {
            if (getLeftChildNode() == null) {
                BinaryTreeNode childNode = new BinaryTreeNode(value);
                setLeftChildNode(childNode);
            } else {
                getLeftChildNode().addNode(value);
            }
        } else  {
            if (getRightChildNode() == null) {
                BinaryTreeNode childNode = new BinaryTreeNode(value);
                setRightChildNode(childNode);
            } else  {
                getRightChildNode().addNode(value);
            }
        }

    }

    public void addCountedNode(int value) {
        setCount(count + 1);
        if (value <= getValue()) {
            if (getLeftChildNode() == null) {
                BinaryTreeNode childNode = new BinaryTreeNode(value);
                setLeftChildNode(childNode);

            } else {
                getLeftChildNode().addCountedNode(value);
            }
        } else  {
            if (getRightChildNode() == null) {
                BinaryTreeNode childNode = new BinaryTreeNode(value);
                setRightChildNode(childNode);

            } else  {
                getRightChildNode().addCountedNode(value);
            }
        }

    }

    // add node with count in right and left
    public void addCountedSidesNode(int value) {
        setCount(count + 1);
        if (value <= getValue()) {
            if (getLeftChildNode() == null) {
                BinaryTreeNode childNode = new BinaryTreeNode(value);
                setLeftChildNode(childNode);
                getLeftChildNode().setParentNode(this);
            } else {
                getLeftChildNode().addCountedSidesNode(value);
            }
            setLeftCount(leftCount + 1);
        } else  {
            if (getRightChildNode() == null) {
                BinaryTreeNode childNode = new BinaryTreeNode(value);
                setRightChildNode(childNode);
                getRightChildNode().setParentNode(this);
            } else  {
                getRightChildNode().addCountedSidesNode(value);
            }
            setRightCount(rightCount + 1);
        }

    }

    // creating the balanced tree
    public void addNodeToBalancedTree(int value) {
        setCount(count + 1);
        if (value <= getValue()) {
            if (getLeftChildNode() == null) {
                BinaryTreeNode childNode = new BinaryTreeNode(value);
                setLeftChildNode(childNode);
                getLeftChildNode().setParentNode(this);

                int diff = getLeftCount() - getRightCount();
                if (diff > 2) {
                    setLeftChildNode(getLeftChildNode().getParentNode());
                }
            } else {
                getLeftChildNode().addCountedSidesNode(value);
            }
            setLeftCount(leftCount + 1);
        } else  {
            if (getRightChildNode() == null) {
                BinaryTreeNode childNode = new BinaryTreeNode(value);
                setRightChildNode(childNode);
                getRightChildNode().setParentNode(this);
            } else  {
                getRightChildNode().addCountedSidesNode(value);
            }
            setRightCount(rightCount + 1);
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

    private ArrayList<Integer> treeWalker(ArrayList<Integer> arrayList) {
        if (this.getLeftChildNode() != null) {
            this.getLeftChildNode().treeWalker(arrayList);
        }

        arrayList.add(value);

        if (this.getRightChildNode() != null) {
            this.getRightChildNode().treeWalker(arrayList);
        }

        return arrayList;

    }

    public int[] treeSort() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList = this.treeWalker(arrayList);
        return ArraySandBox.arrayListToArrayInt(arrayList);
    }



//    public int[] treeCounter(int[] array) {
//        if (this.getLeftChildNode() != null) {
//            this.getLeftChildNode().treeCounter(str);
//        }
//
//        str.;
//
//
//        if (this.getRightChildNode() != null) {
//            this.getRightChildNode().treeCounter(str);
//        }
//
//        return str;
//    }

//    private int[] treeWalkerArray(int[] array, int counter, int counterNext) {
//        if (this.getLeftChildNode() != null) {
//            counter = array.length - 1;
//            counter++;
//            int [] arrayTmp = new int[counter + 1];
//            for (int i = 0; i < array.length; i++) {
//                arrayTmp[i] = array[i];
//            }
//            array = arrayTmp;
//            array = this.getLeftChildNode().treeWalkerArray(array, counter, counterNext);
//            counter--;
//        }
//
//        array[array.length - counter - counterNext] = value;
//
//
//
//        if (this.getRightChildNode() != null) {
//            counter = 0;
//            counterNext = array.length - 1;
//            counterNext++;
//            int [] arrayTmp = new int[counterNext + 1];
//            for (int i = 0; i < array.length; i++) {
//                arrayTmp[i] = array[i];
//            }
//            array = arrayTmp;
//            array = this.getRightChildNode().treeWalkerArray(array, counter, counterNext);
////            counter = array.length - counter;
////            counter++;
//        }
//
//
//        return array;
//    }

//    private int[] treeWalkerArrayRight(int[] array, int counter) {
//        if (this.getRightChildNode() != null) {
//            counter++;
//            int [] arrayTmp = new int[counter + 1];
//            for (int i = 0; i < array.length; i++) {
//                arrayTmp[i] = array[i];
//            }
//            array = arrayTmp;
//            array = this.getRightChildNode().treeWalkerArrayRight(array, counter);
//        }
//
//        array[array.length - counter - 1] = value;
//        return array;
//    }

    private class Conteiner {
        int index;
        int[] array;

        Conteiner(int length) {
            array = new int[length];
        }

        public void put(int value) {
            array[index] = value;
            index++;
        }

        public int[] getArray() {
            return this.array;
        }
    }

    // функция которая обходит и считает число элементов+
    // сделать реализацию дерева, в котором в каждом узле хранится кол-во элементов в этом поддереве - при добавлении при каждом обходе увеличивать индекс
    public int treeCounter() {
        int counter = 0;
        if (this.getLeftChildNode() != null) {
            counter = this.getLeftChildNode().treeCounter();
        }
        counter++;

        if (this.getRightChildNode() != null) {
            counter = counter + this.getRightChildNode().treeCounter();
        }

        return counter;
    }


    public void treeWalkerArray (Conteiner conteiner) {

        if (this.getLeftChildNode() != null) {
            this.getLeftChildNode().treeWalkerArray(conteiner);
        }

        conteiner.put(value);

        if (this.getRightChildNode() != null) {
            this.getRightChildNode().treeWalkerArray(conteiner);
        }

    }



    public int[] treeSortArray() {
        Conteiner conteiner = new Conteiner(treeCounter());
        treeWalkerArray(conteiner);
        return conteiner.getArray();
    }

    // the balaced tree creation



}
