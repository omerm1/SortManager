package com.sparta.om.sorters;

import com.sparta.om.CustomLoggingFormatter;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MergeSorter implements Sorter{
    private static final Logger logger = Logger.getLogger("binary logger");
    @Override
    public int[] sortArray(int[] arrayToSort) {
        try {
            FileHandler fileHandler = new FileHandler("src/main/resources/mergeSort.log", false);
            fileHandler.setLevel(Level.ALL);
            fileHandler.setFormatter(new CustomLoggingFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logger.setUseParentHandlers(false);

        if(arrayToSort.length <= 1) {
            logger.log(Level.FINE, "Array too short to sort, returning as is");
            return arrayToSort;
        }

        int midpoint = arrayToSort.length / 2;
        logger.log(Level.INFO, "Splitting array into 2 arrays");
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
        logger.log(Level.INFO, "Rejoining two arrays into one array");
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
}
