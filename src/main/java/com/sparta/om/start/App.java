package com.sparta.om.start;

import com.sparta.om.exceptions.SorterLoaderException;
import com.sparta.om.sorters.MergeSorter;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SorterLoaderException {
        SortLoader sort = new SortLoader();
        sort.start();
    }
}
