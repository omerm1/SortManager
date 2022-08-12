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
    private final static Scanner scan = new Scanner(System.in);

    public void start() {
        try {
            FileHandler fileHandler = new FileHandler("src/main/resources/sortLoader.log", false);
            fileHandler.setFormatter(new CustomLoggingFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        logger.setUseParentHandlers(false);

        DisplayManager.printMenu();
        int menuChoice = scan.nextInt();
        if (menuChoice == 1) {
            singleChoice();
        } else if (menuChoice == 2) {
            multipleChoice();
        } else {
            System.out.println("Invalid menu choice");
            start();
        }
    }
    public void singleChoice() {
        try {
            logger.log(Level.INFO, "Displaying sorting algo choices");
            DisplayManager.displayChoices();
            int sortingAlgoChoice = scan.nextInt();

            System.out.print("What length would you like the array to be? ");
            int arrayLength = scan.nextInt();

            logger.log(Level.INFO, "Sending random array to sorter");
            Sorter sorter = SortFactory.getSorter(sortingAlgoChoice);

            logger.log(Level.INFO, "Generating random array");
            int[] randomArray = generateRandomArray(arrayLength);
            DisplayManager.printBeforeSorting(sorter, randomArray);

            logger.log(Level.INFO, "Printing results");
            DisplayManager.printResults(sorter, randomArray);
        } catch (SorterLoaderException e) {
            System.out.println(e.getMessage());
            start();
        }
    }

    public void multipleChoice() {
        DisplayManager.displayMultipleChoices();
        int sortingAlgoCompareChoices = scan.nextInt();
        logger.log(Level.INFO, "Creating array of algo choices to compare");
        int[] sortingAlgoCompareChoicesArray = convertIntToArrayOfInts(sortingAlgoCompareChoices);

        System.out.println("What length would you like the array to be?");
        int arrayLength = scan.nextInt();

        logger.log(Level.INFO, "creating array of sorters based on algo choices to compare");
        Sorter[] sorters = new Sorter[sortingAlgoCompareChoicesArray.length];
        for (int i = 0; i < sortingAlgoCompareChoicesArray.length; i++) {
            try {
                sorters[i] = SortFactory.getSorter(sortingAlgoCompareChoicesArray[i]);
            } catch (SorterLoaderException e) {
                System.out.println(e.getMessage());;
            }
        }

        logger.log(Level.INFO, "Generating random array and sending to display manager");
        int[] randomArray = generateRandomArray(arrayLength);
        DisplayManager.printBeforeComparing(sorters, randomArray);

        logger.log(Level.INFO, "Printing compare results");
        DisplayManager.printCompareResults(sorters, randomArray);
    }

    private int[] generateRandomArray(int length) {
        int[] randomArray = new int[length];
        Random random = new Random(1000);
        for (int i = 0; i < length; i++) {
            randomArray[i] = random.nextInt(1000);
        }
        return randomArray;
    }

    private int[] convertIntToArrayOfInts(int num) {
        int[] numArray = Integer.toString(num).chars().map(c -> c-'0').toArray();
        return numArray;
    }
}
