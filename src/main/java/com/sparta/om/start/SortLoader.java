package com.sparta.om.start;

import com.sparta.om.display.DisplayManager;
import com.sparta.om.exceptions.SorterLoaderException;
import com.sparta.om.sorters.Sorter;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortLoader {

    public void start() {
        try {
            Scanner scan = new Scanner(System.in);

            DisplayManager.displayChoices();
            int sortingAlgoChoice = scan.nextInt();

            System.out.print("What length would you like the array to be? ");
            int length = scan.nextInt();

            Sorter sorter = SortFactory.getSorter(sortingAlgoChoice);

            int[] randomArray = generateRandomArray(length);
            DisplayManager.printBeforeSorting(randomArray);

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
