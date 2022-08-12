package com.sparta.om.display;

import com.sparta.om.sorters.Sorter;
import com.sparta.om.start.SortFactory;
import com.sparta.om.start.SortLoader;

import java.util.Arrays;


public class DisplayManager {
    public static void printBeforeSorting(Sorter sorter, int[] randomArray) {
        System.out.println("Sorting using the " + sorter.toString());
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
                "Enter the number here: ");
    }

    public static void displayMultipleChoices() {
        System.out.print("Enter the numbers corresponding with the sorting algorithms you would like to compare: \n" +
                "1 - Bubble Sort \n" +
                "2 - Merge Sort \n" +
                "3 - Binary Sort \n" +
                "Enter the numbers here: ");
    }

    public static void printBeforeComparing(Sorter[] sorters, int[] randomArray) {
        System.out.print("Comparing the ");
        for(Sorter sorter: sorters) {
            System.out.print(sorter.toString() + "; ");
        };
        System.out.print("\n");
        System.out.println("Random array: " + Arrays.toString(randomArray));
    }

    public static void printCompareResults(Sorter[] sorters, int[] randomArray) {
        int[] sortedArray = sorters[0].sortArray(randomArray);
        System.out.println("Ordered array: " + Arrays.toString(sortedArray));

        for (int i = 0; i < sorters.length; i++) {
            System.out.print(sorters[i].toString() + " took ");
            double start = System.nanoTime();
            int[] sortedArrayI = sorters[i].sortArray(randomArray);
            double finish = System.nanoTime();
            System.out.print((finish - start) + " nanoseconds to complete \n");
        }
    }

    public static void printMenu() {
        System.out.print("Would you like to.. \n"+
                "1 - Sort using one algorithm \n"+
                "2 - Compare time taken for multiple algorithms \n" +
                "Enter your choice here: ");
    }
}
