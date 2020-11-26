package com.epam.arrays.task2.service;

import com.epam.arrays.task2.entity.JaggedArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class JaggedArraySortService {

    private static final Logger logger = LogManager.getLogger();

    public void sortRowsByAscendingByTheirSum(JaggedArray jaggedArray) {
        sortRowsByTheirSum(jaggedArray, true);
    }

    public void sortRowsByDescendingByTheirSum(JaggedArray jaggedArray) {
        sortRowsByTheirSum(jaggedArray, false);
    }

    private void sortRowsByTheirSum(JaggedArray jaggedArray, boolean isByAscending) {
        int[][] arr = jaggedArray.getArr();

        int[] sumArr = findSum(arr);

        for (int i = sumArr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (isByAscending) {
                    if (sumArr[j] > sumArr[j + 1]) {
                        rowsSwap(arr, j, j + 1);
                    }
                } else {
                    if (sumArr[j] < sumArr[j + 1]) {
                        rowsSwap(arr, j, j + 1);
                    }
                }
            }
        }
    }

    private int[] findSum(int[][] arr) {
        int[] sumArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            sumArr[i] = 0;
            for (int j = 0; j < arr[i].length; j++) {
                sumArr[i] += arr[i][j];
            }
        }

        return sumArr;
    }

    public void sortRowsByByAscendingByTheirMaxEl(JaggedArray jaggedArray) {
        sortRowsByTheirBoundEl(jaggedArray, true, true);
    }

    public void sortRowsByByDescendingByTheirMaxEl(JaggedArray jaggedArray) {
        sortRowsByTheirBoundEl(jaggedArray, true, false);
    }

    public void sortRowsByByAscendingByTheirMinEl(JaggedArray jaggedArray) {
        sortRowsByTheirBoundEl(jaggedArray, false, true);
    }

    public void sortRowsByByDescendingByTheirMinEl(JaggedArray jaggedArray) {
        sortRowsByTheirBoundEl(jaggedArray, false, false);
    }

    private void sortRowsByTheirBoundEl(JaggedArray jaggedArray, boolean isMaxElement, boolean isByAscending) {
        int[][] arr = jaggedArray.getArr();

        int[] elementsArr = findMaxElements(arr, isMaxElement);

        for (int i = elementsArr.length - 1; i >0; i--) {

            for (int j = 0; j < i; j++) {
                if (isByAscending) {
                    if (elementsArr[j] > elementsArr[j + 1]) {
                        rowsSwap(arr, j, j + 1);
                        elementsSwap(elementsArr, j, j + 1);
                    }
                } else {
                    if (elementsArr[j] < elementsArr[j + 1]) {
                        rowsSwap(arr, j, j + 1);
                        elementsSwap(elementsArr, j, j + 1);
                    }
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            logger.info(Arrays.toString(arr[i]));
        }
    }

    private int[] findMaxElements(int[][] arr, boolean isMax) {
        int[] maxElementsArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            maxElementsArr[i] = arr[i][0];
            for (int j = 0; j < arr[i].length; j++) {
                if (isMax) {
                    if (arr[i][j] > maxElementsArr[i]) {
                        maxElementsArr[i] = arr[i][j];
                    }
                } else {
                    if (arr[i][j] < maxElementsArr[i]) {
                        maxElementsArr[i] = arr[i][j];
                    }
                }
            }
        }

        logger.info(Arrays.toString(maxElementsArr));

        return maxElementsArr;
    }

    private void rowsSwap(int[][] arr, int i, int j) {
        int[] tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private void elementsSwap(int[] elArr, int i, int j) {
        int tmp = elArr[i];
        elArr[i] = elArr[j];
        elArr[j] = tmp;
    }
}
