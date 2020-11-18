package com.dtag.WFMTAT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamSandBox {

    public static void main(String[] args) {
//        ArrayList arrayList = ArraySandBox.randomArrayList(20, 50);
//        ArraySandBox.printArrayList(arrayList);

        int[] numbers = ArraySandBox.randomArrayRange(30, 1, 10);
        ArraySandBox.printArray(numbers);
        System.out.println();
        printArrayStream(numbers);
        sumArray(numbers);
        summArrayStream(numbers);
        ArraySandBox.printArray(returnUneven(numbers));
        System.out.println();
        ArraySandBox.printArray(returnUnevenStream(numbers));
        System.out.println();
        square(numbers);
        squareStream(numbers);
        printArrayStream(numbers);

    }

    public static int[] returnUneven(int[] array) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                list.add(array[i]);
            }
        }

        return ArraySandBox.arrayListToArrayInt(list);
    }

    public static int[] returnUnevenStream(int[] array) {
        return Arrays.stream(array).filter(i -> i % 2 == 0).toArray();
    }

    public static void square(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 3 == 0) {
                array[i] = (int) Math.pow(array[i], 2);
            }
        }

        ArraySandBox.printArray(array);
        System.out.println();
    }

    public static void squareStream(int[] array) {
        ArraySandBox.printArray(
                Arrays.stream(array)
                        .map((s) -> {
                            if (s%3 == 0) {
                                Math.pow(s, 2);
                            }
                            return s;
                        }).toArray()
        );
        System.out.println();
    }

    public static void printArrayStream(int[] array) {
        Arrays.stream(array).forEach(s -> System.out.print(s + "; "));
        System.out.println();
    }

    public static void sumArray(int[] array) {
        int s = 0;

        for (int i = 0; i < array.length; i++) {
            s = s + array[i];
        }

        System.out.println(s);
    }

    public static void summArrayStream(int[] array) {
        System.out.println(Arrays.stream(array).sum());
    }


}
