package com.sparta.om.start;

import com.sparta.om.display.DisplayManager;
import com.sparta.om.exceptions.SorterLoaderException;
import com.sparta.om.sorters.Sorter;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortLoader {
    private static int sortingAlgo;
    private static int length;

    public int[] randomArray;

    public int[] sortedArray;

    private DisplayManager display = new DisplayManager();

    public void start() throws SorterLoaderException {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the number corresponding with the sorting algorithm you would like to use: \n" +
                "1 - Bubble Sort \n" +
                "2 - Merge Sort \n"+
                "Enter the number here:");
        sortingAlgo = scan.nextInt();

        System.out.print("What length would you like the array to be? ");
        length = scan.nextInt();

        SortFactory sortFactory = new SortFactory();
        Sorter sorter = sortFactory.getSorter(sortingAlgo);

        randomArray = new int[length];
        randomArray = generateRandomArray(length);
        System.out.println((Arrays.toString(randomArray)));

        sortedArray = new int[length];
        sortedArray = sorter.sortArray(randomArray);
        System.out.println((Arrays.toString(sortedArray)));

        display.DisplayManager();
    }

    private int[] generateRandomArray(int length) {

        Random random = new Random(1000);
        for (int i = 0; i < length; i++) {
            randomArray[i] = random.nextInt(1000);
        }
        return randomArray;
    }

}
