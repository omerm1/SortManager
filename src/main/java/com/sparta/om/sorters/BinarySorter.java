package com.sparta.om.sorters;

import com.sparta.om.sorters.BinaryTree.BinaryTreeImpl;

public class BinarySorter implements Sorter{
    @Override
    public int[] sortArray(int[] arrayToSort) {
        BinaryTreeImpl binarySort = new BinaryTreeImpl(arrayToSort[0]);
        for (int i = 1; i < arrayToSort.length; i++) {
            binarySort.addElement(arrayToSort[i]);
        }
        return binarySort.getSortedTreeAsc();
    }
}
