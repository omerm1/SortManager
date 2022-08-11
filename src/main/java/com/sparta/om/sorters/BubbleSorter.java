package com.sparta.om.sorters;

public class BubbleSorter implements Sorter{
    @Override
    public int[] sortArray(int[] arrayToSort) {
        int n = arrayToSort.length;
        int temp;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n -1; j++) {
                if (arrayToSort[j] > arrayToSort[j + 1]) {
                    temp = arrayToSort[j];
                    arrayToSort[j] = arrayToSort[j + 1];
                    arrayToSort[j + 1] = temp;
                }
            }
        }
        return arrayToSort;
    }
}
