package com.dtag.TxtAnalysis;

import java.util.ArrayList;
import java.util.HashMap;

public class TextAnalysis {
    private String internalString;

    TextAnalysis(String str) {
        this.internalString = str;
    }

    @Override
    public String toString() {
        return internalString;
    }



    // container for counting words
    private static class Container {
        int value;
        Container(int value) {
            this.value = value;
        }

        public void increase() {
            value++;
        }

    }

    // conteiner for counting chars

    private static class CharContainer extends Container {
         char aChar;

         CharContainer(char aChar, int value) {
             super(value);
             this.aChar = aChar;
         }
    }



//    public <E extends Container> HashMap<E, Integer> counter(E[] inArray) {
//        HashMap<E, Integer> resultMap = new HashMap<>();
//        for (int i = 0; i < inArray.length; i++ ) {
//            if (!resultMap.containsKey(inArray[i])) {
//                E cont = new E(1);
//                resultMap.put(inArray[i], new E(1));
//            } else {
//                resultMap.get(inArray[i]).increase();
//            }
//        }
//
//        for (String key: resultMap.keySet()) {
//            System.out.println(key + ": " + resultMap.get(key).value);
//        }
//
//        return resultMap;
//    }

    public HashMap<String, Container> countEntry() {
        String[] inArray = internalString.split(" ");
        HashMap<String, Container> resultMap = new HashMap<>();

        for (int i = 0; i < inArray.length; i++ ) {
            Container tmp = resultMap.get(inArray[i]);
            if (tmp != null) {
                resultMap.put(inArray[i], new Container(1));
            } else {
                resultMap.get(inArray[i]).increase();
            }
        }

        for (String key: resultMap.keySet()) {
            System.out.println(key + ": " + resultMap.get(key).value);
        }

        return resultMap;
    }

//    public CharContainer[] charCounter() {
//        char[] chars = internalString.toCharArray();
//
//        HashMap<CharContainer, Integer> resultMap = new HashMap<>();
//
//        for (int i = 0; i < chars.length; i++ ) {
//            CharContainer tmp =
//            if (!resultMap.containsKey(chars[i])) {
//                resultMap.put(chars[i], 1);
//            } else {
//                resultMap.;
//            }
//        }
//
//        for (String key: resultMap.keySet()) {
//            System.out.println(key + ": " + resultMap.get(key).value);
//        }
//
//
//
//        CharContainer[] charContainers1 = new CharContainer[charContainers.size()];
//        for (int i = 0; i < charContainers1.length; i++) {
//            charContainers1[i] = charContainers.get(i);
//        }
//
//        for (int i = 0; i < charContainers1.length; i++) {
//            for (int j = 0; j < charContainers1.length - 1 - i; j++) {
//                if (charContainers1[j].value < charContainers1[j+1].value) {
//                    CharContainer tmp = charContainers1[j+1];
//                    charContainers1[j+1] = charContainers1[j];
//                    charContainers1[j] =  tmp;
//                }
//            }
//        }
//
//        return charContainers1;
//
//    }

    public static void printContainers(CharContainer[] charContainers) {
        for (CharContainer cc: charContainers) {
            System.out.println(cc.aChar + " : " + cc.value);
        }
    }


}
