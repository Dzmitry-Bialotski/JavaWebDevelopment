package com.epam.arrays.task1;

import com.epam.arrays.task1.entity.CustomArray;
import com.epam.arrays.task1.service.ArrayInitializationService;
import com.epam.arrays.task1.service.ArraySearchService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InitializationTest {
    ArrayInitializationService arrayInitializationService = new ArrayInitializationService();

    @Test
    void arrayInitializationWithFile() {
        CustomArray expected = new CustomArray(22, 33, 1, -34, 3333, 123);
        CustomArray result = arrayInitializationService.initializeWithFile(
                "F://prog4/Project4/src/resources/data_for_array");
        Assert.assertEquals(result, expected);
    }

    @Test
    void arrayInitializationWithClassRandom() {
        int expectedArrayLength = 10;
        int expectedFrom = 2;
        int expectedTo = 50;

        CustomArray arrRand = arrayInitializationService.initializeWithRandomNumbers(
                expectedArrayLength, expectedFrom, expectedTo);

        Assert.assertEquals(arrRand.size(), expectedArrayLength);


        ArraySearchService searchService = new ArraySearchService();
        int min = searchService.findMin(arrRand);
        int max = searchService.findMax(arrRand);

        Assert.assertTrue(min >= expectedFrom);
        Assert.assertTrue(max <= expectedTo);
    }

}
