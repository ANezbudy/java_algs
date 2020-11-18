package com.dtag.WFMTAT;


import java.util.ArrayList;
import java.util.HashMap;

public class ArraySandBox {
    public static int[] initialOperations(int h) {
        int[] studyArray = new int[h];

        for (int i = 0; i < h; i++) {
            studyArray[i] = i + 1;
        }

//        for (int i = 0; i < studyArray.length; i++ ) {
//            System.out.print(studyArray[i] + "; ");
//        }
        return studyArray;
    }

    public static void printArray(int[] incomeArray) {
        for (int i = 0; i < incomeArray.length; i++ ) {
            System.out.print(incomeArray[i] + "; ");
        }
    }

    public static void printArrayList(ArrayList incomeArrayList) {
//        for (int i = 0; i < incomeArrayList.size(); i++ ) {
//            System.out.print(incomeArrayList.get(i) + "; ");
//        }

        incomeArrayList.stream().forEach(a -> System.out.println(a));
    }

    public static int[] randomArray() {
        int[] randomArray = new int[10];

        for (int i = 0; i < 10; i++) {
            randomArray[i] = (int) (Math.random()*10);
        }

        return randomArray;
    }

    public static ArrayList<Integer> randomArrayList(int n, int range) {
        ArrayList<Integer> randomArrayList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            randomArrayList.add((int) (Math.random()*range));
        }

        return randomArrayList;
    }

    // Написать вторую функцию генерации массивов, чтобы она принимала на вход размерность и диапазон значений
    public static int[] randomArrayRange(int n, int min, int max) {
        int[] randomArray = new int[n];

        for (int i = 0; i < n; i++) {
            randomArray[i] = (int)(Math.random()*((max - min) + 1)) + min;
        }

        return randomArray;
    }

    public static int[] randomArray(int n, int range) {
        int[] randomArray = new int[n];

        for (int i = 0; i < n; i++) {
            randomArray[i] = (int) (Math.random()*range);
        }

        return randomArray;
    }

    public static int[] reverseArray(int[] incomingArray) {
        int[] reversedArray = new int[incomingArray.length];
        int length = incomingArray.length - 1;
        for (int i = 0; i < reversedArray.length; i++) {
            reversedArray[i] = incomingArray[length];
            length--;
        }

        return reversedArray;
    }

    public static int[] reverseArrayOnSite(int[] incomingArray) {

        for (int i = 0; i < incomingArray.length/2; i++) {
                int tmp = incomingArray[i];
                incomingArray[i] = incomingArray[incomingArray.length-(i+1)];
                incomingArray[incomingArray.length-(i+1)] = tmp;
        }

        return incomingArray;
    }

    public static int lexicalComparator(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int strLength = Math.min(chars1.length, chars2.length);

        for (int i = 0; i < strLength; i++) {
            if (chars1[i] < chars2[i]) {
                return -1;
            }

            if (chars1[i] > chars2[i]) {
                return 1;
            }
        }

        // we need to compare lengths of strings only after check of min substrings
        if(chars1.length < chars2.length) {
            return -1;
        } else if(chars1.length > chars2.length) {
            return 1;
        }

        return 0;
    }
    // 1 task
    // Метод, который увеличивает значение каждого элемента массива на 1
    public static int[] increaseEachElement(int[] array) {

        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] + 1;
        }

        return array;
    }

    // 2 task
    // Метод, который сдвигает элементы массива на 1 вправо (при этом последний элемент станет первым)
    public static int[] moveArray(int[] array) {
        int tmp = array[array.length - 1];
        for(int i = array.length - 1; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = tmp;

        return array;
    }

    // 3 task
    // Метод, который домножает каждый второй элемент массива на 2
    public static int[] multiplyEachSecond(int[] array) {
        for (int i = 1; i < array.length; i += 2) {
            array[i] *= 2;
        }
        return array;
    }

    // 4 task
    // Метод, который печатает в консоль элементы массива в обратном порядке
    public static void reversePrint(int[] array) {
        for (int i = array.length - 1; i >= 0; i-- ) {
            System.out.print(array[i] + "; ");
        }
    }
    // можно было воспользоваться предыдущими методами для реверса массива и печати, но, я думаю,
    // это не то, что нужно

    // 5 task
    // Метод, который заменяет элементы массива на противоположные (1->-1 , 2 в -2  и т.д.)
    public static int[] negativeArray(int[] array) {
        for(int i = 0; i < array.length; i++ ) {
            array[i] = 0 - array[i];
        }
        return array;
    }

    // 6 task
    // Метод, который печатает элементы массива по расходящейся от центра
    //(центральный элемент, потом тот, который справа от центрального, потом тот, который слева от центрального и т.д.)

    public static void spreadPrint(int [] array) {

        if (array.length%2 != 0) {
            System.out.print(array[array.length / 2] + "; ");
        }

        for (int i = array.length / 2 - 1, j = array.length / 2 + array.length%2; i >= 0; i--, j++) {
            System.out.print(array[j] + "; ");
            System.out.print(array[i] + "; ");
        }

    }

    public static int[] arrayListToArrayInt(ArrayList<Integer> arrayList) {
        int[] resultArray = new int[arrayList.size()];
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = (Integer) arrayList.get(i);
        }
        return resultArray;
    }

    public static int arraySearch(int[] array, int number) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                return i;
            }
        }

        return -1;
    }

    public static int[] arraySortHashMap (int[] inArray) {
        int[] resultArray = new int[inArray.length];
        HashMap<Integer, Integer> map = HashMapSandbox.countEntryPut(inArray);
        int j = 0;

        for (int key: map.keySet()) {
            for (int i = 1; i <= map.get(key); i++ ) {
                resultArray[j] = key;
                j++;
            }
        }

        return resultArray;
    }









}
