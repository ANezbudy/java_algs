package com.dtag.WFMTAT;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.function.UnaryOperator;


class SimpleSortSandboxTest {

    @org.junit.jupiter.api.Test
    public void insertSort() {
        testSort(SimpleSortSandbox::insertSort);
    }
//
    @org.junit.jupiter.api.Test
    public void mergeSort() {
        testSort(MergeSort::mergeSort);
    }

    @Test
    public void hashMapSort() {
        testSort(ArraySandBox::arraySortHashMap);
    }

    @Test
    public void treeSort() {
        testTreeSort();
    }

    @Test
    public void search() {
        testArraySearch();
    }

    @Test
    public void searchBinary() {
        testBinaryArraySearch();
    }



    public void testSort(UnaryOperator<int[]> sort) {
        for (int i = 1; i <= 1000; i++) {
            for (int j = 1; j <= 20; j++) {
                int[] inputArray = ArraySandBox.randomArray(i, 1000);
                System.out.println();
                System.out.println("i = " + i);
                ArraySandBox.printArray(inputArray);
                System.out.println();
//                int[] tmp = new int[inputArray.length];
//                for (int k = 0; k < inputArray.length; k++) {
//                    tmp[k] = inputArray[k];
//                }
                int[] resultArray = sort.apply(inputArray);
                ArraySandBox.printArray(resultArray);
                System.out.println();
                assert(checkIfSorted(resultArray));
                assert(checkCapability(inputArray, resultArray));
                assert (checkCapabilityMap(inputArray, resultArray));
            }
        }

    }

    public void testTreeSort() {
        for (int i = 1; i < 1000; i++) {
            BinaryTreeNode node = new BinaryTreeNode((int) (Math.random()*1000 +1));
            for (int j = 1; j <= 1000; j++) {
                int k = (int) (Math.random()*1000 + 1);
                node.addNode(k);
            }
            System.out.println("i = " + i);
            System.out.println();
            int[] resultArray = node.treeSortArray();
            ArraySandBox.printArray(resultArray);
            System.out.println();
            assert(checkIfSorted(resultArray));
//            assert(checkCapability(resultArray));
        }
    }

    public void testArraySearch() {
        for (int i = 1; i < 1000; i++) {
            int range = (int)(Math.random()*((100000 - 5) + 1)) + 5;
            int min = 0;
            int max = (int)(Math.random()*100000);
            int[] myArray = ArraySandBox.randomArrayRange(range, min, max);
            System.out.println(i);
            ArraySandBox.printArray(myArray);
            assert (checkSearch(myArray));

        }
    }

    public void testBinaryArraySearch() {
        for (int i = 1; i < 1000; i++) {
            int range = (int)(Math.random()*((100000 - 5) + 1)) + 5;
            int min = 0;
            int max = (int)(Math.random()*100000);
            int[] myArray = ArraySandBox.randomArrayRange(range, min, max);
            myArray = SimpleSortSandbox.insertSort(myArray);
            System.out.println(i);
            ArraySandBox.printArray(myArray);
            int searchable = (int)(Math.random()*100000);
            int result = SearchSandBox.binarySearch(searchable, myArray);
            System.out.println();
            System.out.println(searchable);
            System.out.println(result);
            System.out.println();
            assert (checkBinarySearch(searchable, myArray, result));

        }
    }
    // asserts
    private boolean checkIfSorted(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i+1] < array[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean checkCapability (int[] inputArray, int[] resultArray) {
        ArrayList<Integer> tmpArrayList = new ArrayList<>();
        for (int t : inputArray) {
            tmpArrayList.add(t);
        }

        for (int i = 0; i < resultArray.length; i++) {
            for(int j = 0; j < tmpArrayList.size(); j++) {
                if(resultArray[i] == tmpArrayList.get(j)) {
                    tmpArrayList.remove(tmpArrayList.get(j));
                    break;
                }
            }
        }

        if (tmpArrayList.size() != 0) {
            return false;
        }

        return true;
    }

    private boolean checkCapabilityMap(int[] initialArray, int[] sortedArray) {
        ArraySandBox.printArray(initialArray);
        System.out.println();
        ArraySandBox.printArray(sortedArray);
        System.out.println();
        HashMap<Integer, Integer> initialMap = HashMapSandbox.countEntryPut(initialArray);
        HashMap<Integer, Integer> resultMap = HashMapSandbox.countEntryPut(sortedArray);

        for(Integer key: initialMap.keySet()) {
            if(!initialMap.get(key).equals(resultMap.get(key))) {
                return false;
            }
        }

        return true;
    }

    private boolean checkSearch(int[] incomeArray) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < incomeArray.length; i++) {
            arrayList.add(incomeArray[i]);
        }

        int searchable = (int)(Math.random()*100000);
        int resultArrayList = arrayList.indexOf(searchable);
        int resultArray = ArraySandBox.arraySearch(incomeArray, searchable);
        return resultArrayList == resultArray;
    }

    private boolean checkBinarySearch(int searcheble, int[] incomeArray,  int result) {
        if (result != -1) {
            return (incomeArray[result] == searcheble) ? true : false;
        } else if (result == -1) {
            for (int i = 0; i < incomeArray.length; i++) {
                if (incomeArray[i] == searcheble) {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

//    private boolean checkQuantity() {
//
//    }
}