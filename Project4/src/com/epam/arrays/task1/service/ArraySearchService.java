package com.epam.arrays.task1.service;

import com.epam.arrays.task1.entity.CustomArray;

public class ArraySearchService {

    public int binarySearch(CustomArray arr, int element) {
        int middle = arr.size() / 2;
        int begin = 0;
        int end = arr.size() - 1;

        while (arr.getByIndex(middle) != element && begin <= end) {
            if (arr.getByIndex(middle) > element) {
                end = middle - 1;
            } else {
                begin = middle + 1;
            }
            middle = (end + begin) / 2;
        }

        if (begin <= end) {
            return middle;
        } else {
            return -1;
        }
    }

    private int findEl(CustomArray arr, boolean isMax) {
        int valueIndex = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (isMax) {
                if (arr.getByIndex(valueIndex) < arr.getByIndex(i)) {
                    valueIndex = i;
                }
            } else {
                if (arr.getByIndex(valueIndex) > arr.getByIndex(i)) {
                    valueIndex = i;
                }
            }
        }
        return valueIndex;
    }

    public int findMax(CustomArray arr) {
        int index = findEl(arr, true);
        return arr.getByIndex(index);
    }

    public int findMin(CustomArray arr) {
        int index = findEl(arr, false);
        return arr.getByIndex(index);
    }
}
