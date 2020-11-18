package com.dtag.WFMTAT;

public class CheckPoint {
    public static String checkParameters(Measurable vehicle) {
        // переписать на булевые значения для ошибки - не пересоздавать резалт каждый раз
        String result = "ok";
        String widthErr = "";
        String heightErr = "";
        String weightErr = "";
        Boolean isError = false;

        if(vehicle.getWidth() > 2) {
            isError = true;
            widthErr = " ширина больше 2м,";
        }

        if (vehicle.getHeight() > 3) {
            isError = true;
            heightErr = " высота больше 3м,";
        }

        if (vehicle.getWeight() > 3000) {
            isError = true;
            weightErr = " вес больше 3000,";
        }

        if(isError) {
            result = "ошибка: ";
        }

        return result  + widthErr + heightErr + weightErr;
    }
}
