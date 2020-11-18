package com.dtag.WFMTAT;

public enum Colour {
    BLUE("Синий"),
    GREEN("Зеленый"),
    WHITE("Белый"),
    RED("Красный");

    String russianName;

    Colour (String RussianName) {
        this.russianName = RussianName;
    }

    @Override
    public String toString() {
        return russianName;
    }
}
