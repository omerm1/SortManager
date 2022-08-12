package com.sparta.om.start;

import com.sparta.om.CustomLoggingFormatter;
import com.sparta.om.display.DisplayManager;
import com.sparta.om.exceptions.SorterLoaderException;
import com.sparta.om.sorters.Sorter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class SortLoader {
    private static final Logger logger = Logger.getLogger("sortLoader logger");
    public void start() {
        try {
            try {
                FileHandler fileHandler = new FileHandler("src/main/resources/sortLoader.log", false);
                fileHandler.setFormatter(new CustomLoggingFormatter());
                logger.addHandler(fileHandler);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            logger.setUseParentHandlers(false);


            Scanner scan = new Scanner(System.in);

            logger.log(Level.INFO, "Displaying sorting algo choices");
            DisplayManager.displayChoices();
            int sortingAlgoChoice = scan.nextInt();

            System.out.print("What length would you like the array to be? ");
            int length = scan.nextInt();

            logger.log(Level.INFO, "Sending random array to sorter");
            Sorter sorter = SortFactory.getSorter(sortingAlgoChoice);

            logger.log(Level.INFO, "Generating random array");
            int[] randomArray = generateRandomArray(length);
            DisplayManager.printBeforeSorting(randomArray);

            logger.log(Level.INFO, "Printing results");
            DisplayManager.printResults(sorter, randomArray);
        } catch (SorterLoaderException e) {
            System.out.println(e.getMessage());
            start();
        }
    }

    private int[] generateRandomArray(int length) {
        int[] randomArray = new int[length];
        Random random = new Random(1000);
        for (int i = 0; i < length; i++) {
            randomArray[i] = random.nextInt(1000);
        }
        return randomArray;
    }
}
