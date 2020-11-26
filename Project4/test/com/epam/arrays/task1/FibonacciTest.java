package com.epam.arrays.task1;

import com.epam.arrays.task1.entity.CustomArray;
import com.epam.arrays.task1.service.FibonacciService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FibonacciTest {
    FibonacciService fibonacciService = new FibonacciService();
    CustomArray customArray = new CustomArray(3, -12, 10123, 902, 5, 12, -3, 4, 2, 2, 22, 1, 0, 225, 312);

    @Test
    void findingFibonacciNumbersInArray() {
        CustomArray expected = new CustomArray(0, 1, 2, 2, 3, 5);
        CustomArray result = fibonacciService.findFibonacciNumbsInArray(customArray);

        Assert.assertEquals(result, expected);
    }
}
