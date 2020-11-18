package com.dtag.WFMTAT;

import java.util.HashMap;

public class HashMapSandbox {

    private static class Conteiner {
        int value;
        Conteiner(int value) {
            this.value = value;
        }

        public void increase() {
            value++;
        }
    }

    public static HashMap<Integer, Conteiner> countEntry(int[] inArray) {
        HashMap<Integer, Conteiner> resultMap = new HashMap<>();

        for (int i = 0; i < inArray.length; i++ ) {
            if (!resultMap.containsKey(inArray[i])) {
                resultMap.put(inArray[i], new Conteiner(1));
            } else {
                resultMap.get(inArray[i]).increase();
            }
        }

        for (int key: resultMap.keySet()) {
            System.out.println(key + ": " + resultMap.get(key).value);
        }

        return resultMap;
    }

    public static HashMap<Integer, Integer> countEntryPut(int[] inArray) {
        HashMap<Integer, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < inArray.length; i++) {
            Integer value = resultMap.get(inArray[i]);

            if (value == null) {
                value = 1;
            } else {
                value++;
            }

            resultMap.put(inArray[i], value);

        }

        return resultMap;
    }
}
