package com.sparta.om.sorters;

import com.sparta.om.CustomLoggingFormatter;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MergeSorter implements Sorter{
    @Override
    public int[] sortArray(int[] arrayToSort) {
        if(arrayToSort.length <= 1) {
            return arrayToSort;
        }

        int midpoint = arrayToSort.length / 2;
        int[] left = new int[midpoint];
        int[] right;
        if (arrayToSort.length % 2 == 0) {
            right = new int[midpoint];
        } else {
            right = new int[midpoint + 1];
        }

        for (int i = 0; i < midpoint; i++) {
            left[i] = arrayToSort[i];
        }
        for (int j = 0; j < right.length; j++) {
            right[j] = arrayToSort[midpoint + j];
        }
        left = sortArray(left);
        right = sortArray(right);
        int[] result;
        result = merge(left, right);
        return result;
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int leftPointer, rightPointer, resultPointer;
        leftPointer = rightPointer = resultPointer = 0;
        while(leftPointer < left.length || rightPointer < right.length) {
            if(leftPointer < left.length && rightPointer < right.length) {
                if (left[leftPointer] < right[rightPointer]) {
                    result[resultPointer++] = left[leftPointer++];
                } else {
                    result[resultPointer++] = right[rightPointer++];
                }
            } else if(leftPointer < left.length) {
                result[resultPointer++] = left[leftPointer++];
            } else if (rightPointer < right.length) {
                result[resultPointer++] = right[rightPointer++];
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Merge Sorter";
    }
}
