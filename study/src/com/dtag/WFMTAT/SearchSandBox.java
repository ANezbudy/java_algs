package com.dtag.WFMTAT;

public class SearchSandBox {

    public static int binarySearch(int s, int[] array) {
        int r = array.length - 1;
        int t = 0;

        while (r - t > 1) {
            if (s < array[(r + t)/2]) {
                r = (r + t)/2;
            } else if (s > array[(r + t)/2]) {
                t = (r + t)/2;
            } else if (s == array[(r + t)/2]) {
                return (r + t)/2;
            }
        }

        if (array[r] == s) {
            return r;
        }

        return -1;
    }
}
