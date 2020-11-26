package com.epam.arrays.task1.service;

import com.epam.arrays.task1.entity.CustomArray;

public class SimpleNumberService {

    public CustomArray getAllSimpleNumbers(CustomArray arr) {
        int length = countSimpleNumbers(arr.getArr());
        int[] simpleNumbArray = new int[length];

        int j = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (isSimpleNumber(arr.getByIndex(i))) {
                simpleNumbArray[j] = arr.getByIndex(i);
                j++;
            }
        }

        return new CustomArray(simpleNumbArray);
    }

    private int countSimpleNumbers(int[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (isSimpleNumber(arr[i])) {
                count++;
            }
        }

        return count;
    }

    private boolean isSimpleNumber(int numb) {

        if (numb == 1 || numb == 0) {
            return false;
        }

        boolean isSimple = true;

        int i = 2;
        while (i < Math.abs(numb) && isSimple) {
            if (numb % i == 0) {
                isSimple = false;
            }
            i++;
        }

        return isSimple;
    }
}
