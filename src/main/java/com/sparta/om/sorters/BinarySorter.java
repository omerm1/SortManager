package com.sparta.om.sorters;

import com.sparta.om.CustomLoggingFormatter;
import com.sparta.om.sorters.BinaryTree.BinaryTreeImpl;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class BinarySorter implements Sorter{
    private static final Logger logger = Logger.getLogger("binary logger");
    @Override
    public int[] sortArray(int[] arrayToSort) {
        try {
            FileHandler fileHandler = new FileHandler("src/main/resources/binarySort.log", false);
            fileHandler.setLevel(Level.ALL);
            fileHandler.setFormatter(new CustomLoggingFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logger.setUseParentHandlers(false);

        BinaryTreeImpl binarySort = new BinaryTreeImpl(arrayToSort[0]);
        logger.log(Level.INFO, "Created Binary Tree with first element in list");
        for (int i = 1; i < arrayToSort.length; i++) {
            binarySort.addElement(arrayToSort[i]);
        }
        logger.log(Level.INFO, "Completed Binary Tree with rest of elements in list");
        return binarySort.getSortedTreeAsc();
    }
}
