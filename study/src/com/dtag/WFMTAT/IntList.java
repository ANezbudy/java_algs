package com.dtag.WFMTAT;

public class IntList {
    private IntListElement head;

    IntList (int value) {
        setHead(new IntListElement(value));
    }

    public IntListElement getHead() {
        return head;
    }

    public IntListElement getTail() {
        IntListElement currentElement = getHead();

        while (currentElement != null) {
            currentElement = currentElement.getNextElement();
        }

        return currentElement;
    }

    public void setHead(IntListElement head) {
        this.head = head;
    }

    public void printList() {
        IntListElement currentElement = head;

        while (currentElement != null) {
            System.out.print(currentElement.getValue() + "; ");
//            System.out.println();
            currentElement = currentElement.getNextElement();
        }
    }

    public void addElementToHead(int value) {
        addElementToHead(new IntListElement(value));
    }

    public void addElementToHead(IntListElement element) {
        head.setPrevElement(element);
        element.setNextElement(head);
        head = element;
    }

    public void addElementToTail(int value) {
        addElementToTail(new IntListElement(value));
    }

    public void addElementToTail(IntListElement element) {
        IntListElement currentElement = head;
        while (currentElement.getNextElement() != null) {
            currentElement = currentElement.getNextElement();
        }

        currentElement.setNextElement(element);
        element.setPrevElement(currentElement);
    }

    //загрузить массив в список, и распечатать его
    public static IntList putArrayInList(int[] array) {
        IntList list = new IntList(array[0]);

        for(int i = 1; i < array.length; i++) {
            list.addElementToTail(array[i]);
        }

        return list;
    }

    //напечатать элементы массива в обратном порядке с помощью списка
    public static void printReversedArray(int[] array) {
        IntList list = new IntList(array[0]);

        for(int i = 1; i < array.length; i++) {
            list.addElementToHead(array[i]);
        }

        list.printList();
    }

    //реверсировать массив с помощью списка
    public static int[] reverseArray(int[] array) {
        IntList list = new IntList(array[0]);

        for(int i = 0; i < array.length; i++) {
            list.addElementToHead(array[i]);
        }

        int[] reversedArray = new int[array.length];
        reversedArray[0] = list.getHead().getValue();
        IntListElement currentElement = list.getHead();

        for(int i = 1; i < reversedArray.length; i++) {
            reversedArray[i] = currentElement.getNextElement().getValue();
            currentElement = currentElement.getNextElement();
        }

        return reversedArray;
    }

    // list to array
    public int[] listToArray() {
        int counter = 0;
        IntListElement currentElement = getHead();

        while (currentElement != null) {
            counter++;
            currentElement = currentElement.getNextElement();
        }

        int[] array = new int[counter];
        array[0] = getHead().getValue();


        for(int i = 1; i < array.length; i++) {
            array[i] = currentElement.getNextElement().getValue();
            currentElement = currentElement.getNextElement();
        }

        return array;
    }

    public int size() {
        int counter = 0;
        IntListElement currentElement = getHead();

        while (currentElement != null) {
            counter++;
            currentElement = currentElement.getNextElement();
        }

        return counter;
    }

    public IntList reverseList() {
        // implement the reverce of current list without creation the new one
        IntList outList = new IntList(getHead().getValue());

        IntListElement currentElement = getHead();

        while (currentElement.getNextElement() != null) {
            outList.addElementToHead(currentElement.getNextElement().getValue());
            currentElement = currentElement.getNextElement();
        }

        return outList;
    }

    public boolean removeListNode(int value) {
        IntListElement currentElement = getHead();

        if(currentElement.getValue() == value) {
            setHead(currentElement.getNextElement());
            return true;
        }

        while (currentElement.getNextElement() != null) {
            if (currentElement.getNextElement().getValue() == value) {
                // to manage the case with tail - if there is no nexElement

//                currentElement.setValue(currentElement.getNextElement().getValue());
                currentElement.setNextElement(currentElement.getNextElement().getNextElement());
                return true;
            }
            currentElement = currentElement.getNextElement();
        }

        return false;
    }

    // implement the deletion of several (all) elements - to return the quantity of deleted

    public int removeAllNodes(int value) {
        int counter = 0;
        IntListElement currentElement = getHead();

        while (getHead().getValue() == value) {
            if(currentElement.getValue() == value) {
                setHead(currentElement.getNextElement());
                currentElement = getHead();
                counter++;
            }
        }

        while (currentElement != null && currentElement.getNextElement() != null) {
            if (currentElement.getNextElement().getValue() == value) {
                currentElement.setNextElement(currentElement.getNextElement().getNextElement());
                counter++;
                continue;
            }
            currentElement = currentElement.getNextElement();
        }

        return counter;
    }

    // implement the case with two links - to the previous element and to the next/ Create the link for the previous, manage the case with the head

    public boolean removeListNodeLinked(int value) {
        IntListElement currentElement = getHead();

        if(currentElement.getValue() == value) {
            setHead(currentElement.getNextElement());
            return true;
        }



        while (currentElement.getNextElement() != null) {
//            if (currentElement.getNextElement().getValue() == value) {
//
//                currentElement.setNextElement(currentElement.getNextElement().getNextElement());
//                return true;
//            }
            if(currentElement.getValue() == value) {
                currentElement.getNextElement().setPrevElement(currentElement.getPrevElement());
                return true;
            }
            currentElement = currentElement.getNextElement();
        }

        return false;
    }

}
