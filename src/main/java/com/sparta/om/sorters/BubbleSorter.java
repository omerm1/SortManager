package com.sparta.om.sorters;

import com.sparta.om.CustomLoggingFormatter;

import java.io.IOException;
import java.util.logging.*;

public class BubbleSorter implements Sorter{
    private static final Logger logger = Logger.getLogger("my logger");
    @Override
    public int[] sortArray(int[] arrayToSort) {
        try {
            FileHandler fileHandler = new FileHandler("src/main/resources/bubbleSort.log", false);
            fileHandler.setLevel(Level.ALL);
            fileHandler.setFormatter(new CustomLoggingFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        logger.setUseParentHandlers(false);

        logger.log(Level.INFO, "Bubble Sort started");
        int n = arrayToSort.length;
        int temp;
        logger.log(Level.INFO, "Ints temp and array length(" + n + ") assigned");
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n -1; j++) {
                if (arrayToSort[j] > arrayToSort[j + 1]) {
                    temp = arrayToSort[j];
                    arrayToSort[j] = arrayToSort[j + 1];
                    arrayToSort[j + 1] = temp;
                }
            }
        }
        logger.log(Level.INFO, "Loops done - about to return statement");
        return arrayToSort;
    }
}
