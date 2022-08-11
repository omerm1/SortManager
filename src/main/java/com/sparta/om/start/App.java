package com.sparta.om.start;

import com.sparta.om.exceptions.SorterLoaderException;

public class App 
{
    public static void main( String[] args ) {
        SortLoader sort = new SortLoader();
        sort.start();
    }
}
