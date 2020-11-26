package com.epam.arrays.task1.service;

import com.epam.arrays.task1.entity.CustomArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class FibonacciService {

    private static final Logger logger = LogManager.getLogger();

    public CustomArray findFibonacciNumbsInArray(CustomArray arr) {
        ArraySearchService searchService = new ArraySearchService();

        int limit = searchService.findMax(arr);
        int[] fibonacci = findFibonacciNumbs(limit);

        int length = findNumberOfCoincidences(arr, fibonacci);
        int[] fibonacciNumbsInArr = new int[length];

        int k = 0;
        for (int j = 0; j < fibonacci.length; j++) {
            for (int i = 0; i < arr.size(); i++) {
                if (arr.getByIndex(i) == fibonacci[j]) {
                    fibonacciNumbsInArr[k] = fibonacci[j];
                    k++;
                }
            }
        }

        return new CustomArray(fibonacciNumbsInArr);
    }

    private int findNumberOfCoincidences(CustomArray arr, int[] fibonacci) {
        int count = 0;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < fibonacci.length; j++) {
                if (arr.getByIndex(i) == fibonacci[j]) {
                    count++;
                }
            }
        }
        logger.info("Number of coincidences " + count);
        return count;
    }

    private int[] findFibonacciNumbs(int limit) {
        int length = findFibonacciLength(limit);
        int[] fibonacci = new int[length];

        int actual = 1;
        int previous = 0;
        fibonacci[0] = previous;

        int i = 1;
        while (actual + previous <= limit) {
            actual = previous + actual;
            previous = actual - previous;
            fibonacci[i] = actual;
            i++;
        }

        logger.info("Fibonacci array: \n" + Arrays.toString(fibonacci));
        return fibonacci;
    }

    private int findFibonacciLength(int limit) {
        int actual = 1;
        int previous = 0;
        int count = 1;

        while (actual + previous <= limit) {
            actual = previous + actual;
            previous = actual - previous;
            count++;
        }

        logger.info("Fibonacci number limit: " + limit);
        return count;
    }
}
