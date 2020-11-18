package com.dtag.WFMTAT;

import java.util.ArrayList;

public class MergeSort {
    public static int[] mergeSort(int[] myArray) {
        ArrayList<ArrayList> tmpArraList = new ArrayList<>();
        for (int i = 0; i < myArray.length; i++) {
            ArrayList<Integer> tmpList = new ArrayList<>();
            tmpList.add(myArray[i]);
            tmpArraList.add(tmpList);
        }

        while (tmpArraList.size() > 1) {
            ArrayList<ArrayList> tmpArraList1 = new ArrayList<>();
            for (int i = 1; i < tmpArraList.size(); i += 2) {
                ArrayList<ArrayList> tmp = new ArrayList<>();
                tmp.add(mergeArrays(tmpArraList.get(i - 1), tmpArraList.get(i)));
                for(ArrayList arr : tmp) {
                    tmpArraList1.add(arr);
                }
            }

            if ((tmpArraList.size() % 2) != 0) {
                tmpArraList1.add(tmpArraList.get(tmpArraList.size() - 1));
            }
            tmpArraList = tmpArraList1;

        }

        int[] resultArray = new int[tmpArraList.get(0).size()];
        for (int i = 0; i < tmpArraList.get(0).size(); i++) {
            resultArray[i] = (Integer) tmpArraList.get(0).get(i);
        }
        return resultArray;
    }

    public static ArrayList mergeArrays(ArrayList<Integer> arrayList1, ArrayList<Integer> arrayList2) {
        ArrayList<Integer> resultArray = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < arrayList1.size() && j < arrayList2.size()) {
                if (arrayList1.get(i) <= arrayList2.get(j)) {
                    resultArray.add(arrayList1.get(i));
                    i++;
                } else if (arrayList1.get(i) > arrayList2.get(j)) {
                    resultArray.add(arrayList2.get(j));
                    j++;
                }
        }

        while (i < arrayList1.size()) {
            resultArray.add(arrayList1.get(i));
            i++;
        }

        while (j < arrayList2.size()) {
            resultArray.add(arrayList2.get(j));
            j++;
        }

        return resultArray;

    }
}
