package com.epam.arrays.task1;

import com.epam.arrays.task1.entity.CustomArray;
import com.epam.arrays.task1.service.SimpleNumberService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleNumberTest {
    CustomArray customArray = new CustomArray(3, -12, 10123, 902, 5, 12, -3, 4, 2, 2, 22, 1, 0, 225, 312);
    SimpleNumberService simpleNumberService = new SimpleNumberService();

    @Test
    void findAllSimpleNumbersInArr() {
        CustomArray expected = new CustomArray(3, 5, -3, 2, 2);
        CustomArray res = simpleNumberService.getAllSimpleNumbers(customArray);

        Assert.assertEquals(res, expected);
    }
}
