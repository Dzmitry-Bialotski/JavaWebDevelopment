package com.epam.arrays.task2.report;

import com.epam.arrays.task2.entity.JaggedArray;

public class JaggedArrayReporter {
    public void printJaggedArray(JaggedArray jaggedArray) {
        int[][] arr = jaggedArray.getArr();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + ", ");
            }
            System.out.println("");
        }
    }
}
