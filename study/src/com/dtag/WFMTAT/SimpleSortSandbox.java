package com.dtag.WFMTAT;

import java.util.ArrayList;
import java.util.Arrays;

public class SimpleSortSandbox {

    public static int[] createRandomArray(int n) {
        int[] randomArray = new int[n];

        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = (int) (Math.random() *9 + 1);
        }

        return randomArray;
    }

    public static int findMinElement(int[] incomingArray) {
        int min = incomingArray[0];
        for (int i = 1; i < incomingArray.length; i++) {
            if (incomingArray[i] <  min) {
                min = incomingArray[i];
            }
        }

        return min;
    }

    public static int findMaxElement(int[] incomingArray) {
        int max = incomingArray[0];
        for (int i = 1; i < incomingArray.length; i++) {
            if (incomingArray[i] > max) {
                max = incomingArray[i];
            }
        }

        return max;
    }

    public static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j+1]) {
                    int tmp = array[j+1];
                    array[j+1] = array[j];
                    array[j] =  tmp;
                }
            }
        }

        return array;
    }

//    public static int[] minSearchSort(int[] array) {
//        int[] tmpArray = array;
//        for (int i = 0; i < array.length; i++) {
//            int tmpMin = findMinElement(tmpArray);
//            for (int j =i+1; j < array.length; j++) {
//                if (array[j] == tmpMin) {
//                    array[j] = array[i];
//                    break;
//                }
//            }
//            array[i] = tmpMin;
//            tmpArray = Arrays.copyOfRange(array, i+1, array.length);
//        }
//
//        return array;
//    }

    public static int[] minSearchSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = tmp;
        }

        return array;
    }

    public static int[] insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] < array[j]) {
                    int tmp = array[j];
                    array[j] = array[i];
                    for (int k = i; k > j; k--) {
                        array[k] = array[k - 1];
                    }
                    array[j+1] = tmp;
                }
            }
        }

        return array;
    }


    public static void launcher(int n) {
        int[] sampleArray = createRandomArray(n);
        int min = findMinElement(sampleArray);
        int max = findMaxElement(sampleArray);

        ArraySandBox.printArray(sampleArray);
        System.out.println();
        System.out.println(min);
        System.out.println(max);
//        bubbleSort(sampleArray);
//        minSearchSort(sampleArray);
        insertSort(sampleArray);
        ArraySandBox.printArray(sampleArray);
    }


}
