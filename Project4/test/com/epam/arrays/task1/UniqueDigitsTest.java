package com.epam.arrays.task1;

import com.epam.arrays.task1.entity.CustomArray;
import com.epam.arrays.task1.service.UniqueDigitsService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UniqueDigitsTest {
    CustomArray customArray = new CustomArray(3, -12, 10123, 902, 5, 12, -3, 4, 2, 2, 22, 1, 0, 225, 312);
    UniqueDigitsService uniqueDigitsService = new UniqueDigitsService();

    @Test
    void findNumbsTest() {
        CustomArray expected = new CustomArray(902, 312);
        CustomArray res = uniqueDigitsService.findNumbsWithUniqueDigits(customArray, 3);

        Assert.assertEquals(res, expected);
    }
}
