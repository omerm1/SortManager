package com.sparta.om.display;

import com.sparta.om.start.SortFactory;
import com.sparta.om.start.SortLoader;

import java.util.Arrays;


public class DisplayManager {
    private static SortLoader sort = new SortLoader();
    private static SortFactory sortFactory = new SortFactory();

    public void DisplayManager() {
        System.out.println("Your choice of Sorting Algorithm: "+ sortFactory.sortAlgoChoice);
        System.out.println("Randomised array: "+ Arrays.toString(sort.randomArray));
        System.out.println("Ordered array: "+ Arrays.toString(sort.sortedArray));
    }

}
