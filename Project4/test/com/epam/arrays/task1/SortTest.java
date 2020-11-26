package com.epam.arrays.task1;

import com.epam.arrays.task1.entity.CustomArray;
import com.epam.arrays.task1.service.ArraySortService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SortTest {
    ArraySortService arraySortService = new ArraySortService();
    CustomArray expected = new CustomArray(-12, -3, 0, 1, 2, 2, 4, 12, 22, 312, 902, 10123);

    @Test
    void bubbleSortTest() {
        CustomArray customArray = new CustomArray(-12, 10123, 902, 12, -3, 4, 2, 2, 22, 1, 0, 312);
        arraySortService.bubbleSort(customArray);
        Assert.assertEquals(customArray, expected);
    }

    @Test
    void selectionSortTest() {
        CustomArray customArray = new CustomArray(-12, 10123, 902, 12, -3, 4, 2, 2, 22, 1, 0, 312);
        arraySortService.selectionSort(customArray);
        Assert.assertEquals(customArray, expected);
    }

    @Test
    void quickSortTest() {
        CustomArray customArray = new CustomArray(-12, 10123, 902, 12, -3, 4, 2, 2, 22, 1, 0, 312);
        arraySortService.quickSort(customArray, 0, customArray.size() - 1);
    }

}
