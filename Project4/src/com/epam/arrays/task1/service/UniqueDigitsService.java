package com.epam.arrays.task1.service;

import com.epam.arrays.task1.entity.CustomArray;

public class UniqueDigitsService {
    public CustomArray findNumbsWithUniqueDigits(CustomArray arr, int numbLength) {
        int length = findLengthOfUniqueDigitsArr(arr.getArr(), numbLength);
        int[] unicDigitsArr = new int[length];

        int i = 0;
        for (int el : arr.getArr()) {
            int tmpNum = Math.abs(el);
            if (String.valueOf(tmpNum).length() == numbLength) {
                int[] digitsArr = divideIntoDigits(el, numbLength);
                boolean isNotEqual = isDigitsNotEqual(digitsArr);
                if (isNotEqual) {
                    unicDigitsArr[i] = el;
                    i++;
                }
            }
        }

        return new CustomArray(unicDigitsArr);
    }

    private int findLengthOfUniqueDigitsArr(int[] arr, int numbLength) {
        int length = 0;
        for (int el : arr) {
            int tmpNum = Math.abs(el);
            if (String.valueOf(tmpNum).length() == numbLength) {
                int[] digitsArr = divideIntoDigits(el, numbLength);
                boolean isNotEqual = isDigitsNotEqual(digitsArr);
                if (isNotEqual) {
                    length++;
                }
            }
        }
        return length;
    }

    private int[] divideIntoDigits(int numb, int numbLength) {
        int[] arr = new int[numbLength];

        for (int i = 0; i < numbLength; i++) {
            arr[i] = numb % 10;
            numb /= 10;
        }

        return arr;
    }

    private boolean isDigitsNotEqual(int[] digitsArr) {
        boolean isNotEqual = true;
        int i = 0;
        while (i < digitsArr.length && isNotEqual) {
            int j = i + 1;
            while (j < digitsArr.length && isNotEqual) {
                if (digitsArr[i] == digitsArr[j]) {
                    isNotEqual = false;
                }
                j++;
            }
            i++;
        }

        return isNotEqual;
    }
}
