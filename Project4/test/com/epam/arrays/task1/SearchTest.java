package com.epam.arrays.task1;

import com.epam.arrays.task1.entity.CustomArray;
import com.epam.arrays.task1.service.ArraySearchService;
import com.epam.arrays.task1.service.ArraySortService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest {
    CustomArray customArray = new CustomArray(3, -12, 10123, 902, 5, 12, -3, 4, 2, 2, 22, 1, 0, 225, 312);
    ArraySearchService searchService = new ArraySearchService();

    @Test
    void FindMinTest() {
        int expected = -12;
        int res = searchService.findMin(customArray);

        Assert.assertEquals(res, expected);
    }

    @Test
    void findMaxTest() {
        int expected = 10123;
        int res = searchService.findMax(customArray);

        Assert.assertEquals(res, expected);
    }

    @Test
    void findIndexOfAnElementByABinarySearch() {
        ArraySortService sortService = new ArraySortService();
        sortService.quickSort(customArray,0,customArray.size()-1);

        int element = 12;
        int expectedIndex = 9;
        int res = searchService.binarySearch(customArray, 12);

        Assert.assertEquals(res,expectedIndex);
    }
}
