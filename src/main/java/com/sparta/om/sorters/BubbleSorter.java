package com.sparta.om.sorters;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BubbleSorter implements Sorter{
    private static final Logger logger = Logger.getLogger("my logger");
    private static final ConsoleHandler consoleHandler = new ConsoleHandler();
    @Override
    public int[] sortArray(int[] arrayToSort) {
        consoleHandler.setLevel(Level.ALL);

        logger.addHandler(consoleHandler);
        logger.setLevel(Level.ALL);
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
