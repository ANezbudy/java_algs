package com.dtag.WFMTAT;

import java.sql.Struct;
import java.util.ArrayList;

public class Censor {

    private static String[] dictionary = {"Вася", "в", "к", "который", "на", "слово", "надел"};

    public static String censor(String initialString) {
        String [] arrayWords = initialString.split(" ");
        ArrayList<String> arrayListWords = new ArrayList<>();

        for (int i = 0; i < arrayWords.length; i++) {
            arrayListWords.add(arrayWords[i]);
        };

        String resultStr = "";

        for (int j = 0; j < arrayListWords.size(); j++) {
            for (int i = 0; i < dictionary.length; i++) {
                if (arrayListWords.get(j).equals(dictionary[i])) {
                    arrayListWords.remove(arrayListWords.get(j));
                }
            }
        }




        for (String s: arrayListWords) {
            resultStr = resultStr + s + " ";
        }

        return resultStr;
    }
}
