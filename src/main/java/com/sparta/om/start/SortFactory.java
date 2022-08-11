package com.sparta.om.start;

import com.sparta.om.exceptions.SorterLoaderException;
import com.sparta.om.sorters.BinarySorter;
import com.sparta.om.sorters.BubbleSorter;
import com.sparta.om.sorters.MergeSorter;
import com.sparta.om.sorters.Sorter;

public class SortFactory {
    public static String sortAlgoChoice;
    public static Sorter getSorter(int choice) throws SorterLoaderException {
        switch(choice) {
            case 1:
                sortAlgoChoice = "Bubble Sort";
                return new BubbleSorter();
            case 2:
                sortAlgoChoice = "Merge Sort";
                return new MergeSorter();
            case 3:
                sortAlgoChoice = "Binary Sort";
                return new BinarySorter();
            default:
                throw new SorterLoaderException("Invalid Sorter choice " + choice);
        }
    }
}
