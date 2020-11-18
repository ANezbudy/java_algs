package com.dtag.WFMTAT;

public enum EventType {
    WEDDING("Свадьба"),
    BENEFIT_EVENING("Благотворительный вечер"),
    POCKER("Покер"),
    WOLK("Прогулка с друзьями");


    String publicEvent;

    EventType(String publicEvent) {
        this.publicEvent = publicEvent;
    }


    @Override
    public String toString() {
        return publicEvent;
    }
}
