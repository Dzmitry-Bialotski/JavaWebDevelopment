package com.epam.arrays.task1.service;

import com.epam.arrays.task1.entity.CustomArray;

public class ArraySortService {

    public void selectionSort(CustomArray arr) {
        for (int i = 0; i < arr.size() - 1; i++) {
            int minValueIndex = i;
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.getByIndex(minValueIndex) > arr.getByIndex(j)) {
                    minValueIndex = j;
                }
            }
            swap(arr, i, minValueIndex);
        }
    }

    public void bubbleSort(CustomArray arr) {
        for (int i = arr.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr.getByIndex(j) >= arr.getByIndex(j + 1)) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public void quickSort(CustomArray arr, int begin, int end) {
        if (begin < end) {
            int partition = findPartition(arr, begin, end);
            quickSort(arr, begin, partition - 1);
            quickSort(arr, partition + 1, end);
        }
    }

    private int findPartition(CustomArray arr, int begin, int end) {
        int pivot = arr.getByIndex(end);
        int i = begin;

        for (int j = begin; j < end; j++) {
            if (arr.getByIndex(j) <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, end);

        return i;
    }

    private void swap(CustomArray arr, int i, int j) {
        int tmp = arr.getByIndex(i);
        arr.setValueByIndex(i, arr.getByIndex(j));
        arr.setValueByIndex(j, tmp);
    }

}
