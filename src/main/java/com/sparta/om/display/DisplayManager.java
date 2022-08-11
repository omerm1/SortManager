package com.sparta.om.display;

import com.sparta.om.sorters.Sorter;
import com.sparta.om.start.SortFactory;
import com.sparta.om.start.SortLoader;

import java.util.Arrays;


public class DisplayManager {
    public static void printBeforeSorting(int[] randomArray) {
        SortFactory sorter = new SortFactory();
        System.out.println("Sorting using the " + sorter.sortAlgoChoice);
        System.out.println("Random array: " + Arrays.toString(randomArray));
    }

    public static void printResults(Sorter sorter, int[] randomArray) {
        double start = System.nanoTime();
        int[] sortedArray = sorter.sortArray(randomArray);
        System.out.println("Ordered array: " + Arrays.toString(sortedArray));
        double finish = System.nanoTime();
        System.out.println("Time taken for sorting: " + (finish - start) + " nanoseconds");
    }

    public static void displayChoices() {
        System.out.print("Enter the number corresponding with the sorting algorithm you would like to use: \n" +
                "1 - Bubble Sort \n" +
                "2 - Merge Sort \n" +
                "3 - Binary Sort \n" +
                "Enter the number here:");
    }

}
