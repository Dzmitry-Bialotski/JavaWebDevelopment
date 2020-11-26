package com.epam.arrays.task1.report;

import com.epam.arrays.task1.entity.CustomArray;

public class ArrayPrinter {
    public void printArray(CustomArray arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.getByIndex(i) + " ");
        }

        System.out.println("");
    }
}
