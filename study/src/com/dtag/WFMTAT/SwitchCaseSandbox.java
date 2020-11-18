package com.dtag.WFMTAT;

public class SwitchCaseSandbox {
    //1 - Синий
    //2 - Красный
    //3 - Зеленый
    //4 - Белый

    public static int getTShirtColorWithIf(int trousersColor) {
        if(trousersColor == 1) {
            return 4;
        } else if (trousersColor == 2) {
            return 2;
        } else if (trousersColor == 3) {
            return 4;
        } else if (trousersColor == 4) {
            return 3;
        }
        return 4;
    }

    public static int getTShirtColour (int trousersColor) {
        int r = 0;
        switch (trousersColor) {
            case 1:
                r = 4;
                break;
            case 2:
                r = 2;
                break;
            case 3:
                r = 4;
                break;
            case 4:
                r = 3;
                break;

            default:
                r = 4;
        }
        System.out.println("t: " + trousersColor + "r: " + r);
        return r;
    }

    public static Colour getTShirtColour (Colour trousersColor) {
        Colour r = Colour.WHITE;
        switch (trousersColor) {
            case BLUE:
                r = Colour.WHITE;
                break;
            case RED:
                r = Colour.RED;
                break;
            case GREEN:
                r = Colour.WHITE;
                break;
            case WHITE:
                r = Colour.GREEN;
                break;

            default:
                r = Colour.WHITE;
        }
        System.out.println("t: " + trousersColor + "r: " + r.ordinal() + "; name: " + r.name());
        return r;
    }

    //create function to choose the clothes for event

    public static Outfit getOutfitForEvent(EventType eventType) {
        Outfit o = Outfit.CASUAL;
        switch (eventType) {
            case WOLK:
                o = Outfit.CASUAL;
                break;
            case WEDDING:
                o = Outfit.TUXEDO;
                break;
            case BENEFIT_EVENING:
                o = Outfit.TUXEDO;
                break;
            case POCKER:
                o = Outfit.SUITE;
                break;

            default:
                o = Outfit.SUITE;
        }

        return o;
    }

    public static void faceControl(Outfit outfit, EventType eventType) {
        if (outfit == getOutfitForEvent(eventType)) {
            System.out.println("The " + outfit.toString() + " suits the event: " + eventType.toString());
        } else {
            System.out.printf("The " + outfit.toString() + " does not suits the event: " + eventType.toString());
        }

//        if(EventType.WEDDING && (outfit.TUXEDO || outfit.SUITE)) {
//            System.out.println("Ok!");
//        }
    }

    public static void printColours() {
        for (Colour c: Colour.values()) {
            System.out.println("Name: " + c + "; ordinal: " + c.ordinal());
        }
    }


}
