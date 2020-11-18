package com.dtag.WFMTAT;

public enum Outfit {
    SUITE("Костюм"),
    CASUAL("Джинсы и футболка"),
    TUXEDO("Смокинг");

    String clothes;

    Outfit (String clothes) {
        this.clothes = clothes;
    }

    @Override
    public String toString() {
        return clothes;
    }
}
