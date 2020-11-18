package com.dtag.WFMTAT;

public class IntListElement {
    private int value;
    private IntListElement nextElement;
    private IntListElement prevElement;

    IntListElement(int value, IntListElement nextElement) {
        setValue(value);
        setNextElement(nextElement);
    }

    IntListElement(int value, IntListElement nextElement, IntListElement prevElement) {
        setValue(value);
        setNextElement(nextElement);
        setPrevElement(prevElement);
    }

    IntListElement(int value) {
        setValue(value);
        setNextElement(null);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public IntListElement getNextElement() {
        return nextElement;
    }

    public void setNextElement(IntListElement nextElement) {
        this.nextElement = nextElement;
    }

    public IntListElement getPrevElement() {
        return prevElement;
    }

    public void setPrevElement(IntListElement prevElement) {
        this.prevElement = prevElement;
    }
}
