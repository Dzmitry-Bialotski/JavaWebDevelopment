package com.epam.arrays.task2;

import com.epam.arrays.task2.entity.JaggedArray;
import com.epam.arrays.task2.service.JaggedArraySortService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JaggerArraySortTest {
    JaggedArraySortService arraySortService = new JaggedArraySortService();


    @Test
    void sortRowsByAscendingByTheirSumTest() {
        JaggedArray array = new JaggedArray(
                new int[]{-5, 10, 3},           //8
                new int[]{4, -8, 9, 3, 6},      //14
                new int[]{9, 0}                 //9
        );

        JaggedArray expected = new JaggedArray(
                new int[]{-5, 10, 3},
                new int[]{9, 0},
                new int[]{4, -8, 9, 3, 6}
        );

        arraySortService.sortRowsByAscendingByTheirSum(array);

        System.out.println();
        Assert.assertEquals(array, expected);
    }

    @Test
    void sortRowsByTheirMaxElTest(){
        JaggedArray array = new JaggedArray(
                new int[]{-5, 10, 3},           //8
                new int[]{4, -8, 9, 3, 6},      //14
                new int[]{9, 0}                 //9
        );

        JaggedArray expected = new JaggedArray(
                new int[]{4, -8, 9, 3, 6},
                new int[]{9, 0},
                new int[]{-5, 10, 3}
        );

        arraySortService.sortRowsByByAscendingByTheirMaxEl(array);

        Assert.assertEquals(array,expected);
    }
}
