package com.sparta.om;

import com.sparta.om.sorters.BinarySorter;
import com.sparta.om.sorters.BubbleSorter;
import com.sparta.om.sorters.MergeSorter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class sorterTests {
    @Test
    @DisplayName("Given random array return bubble sorted array")
    void givenRandomArrayReturnBubbleSortedArray() {
        BubbleSorter bubblesort = new BubbleSorter();
        int[] randomArray = {3,4,52,1,3,56,3,6};
        int[] expected = {1,3,3,3,4,6,52,56};

        Assertions.assertEquals(Arrays.toString(expected), Arrays.toString(bubblesort.sortArray(randomArray)));
    }

    @Test
    @DisplayName("Given random array return merge sorted array")
    void givenRandomArrayReturnMergeSortedArray() {
        MergeSorter mergesort = new MergeSorter();
        int[] randomArray = {3,4,52,1,3,56,3,6};
        int[] expected = {1,3,3,3,4,6,52,56};

        Assertions.assertEquals(Arrays.toString(expected), Arrays.toString(mergesort.sortArray(randomArray)));
    }

    @Test
    @DisplayName("Given random array return binary sorted array")
    void givenRandomArrayReturnBinarySortedArray() {
        BinarySorter binarySort = new BinarySorter();
        int[] randomArray = {3,4,52,1,3,56,3,6};
        int[] expected = {1,3,3,3,4,6,52,56};

        Assertions.assertEquals(Arrays.toString(expected), Arrays.toString(binarySort.sortArray(randomArray)));
    }

}
