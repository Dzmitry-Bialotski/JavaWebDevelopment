package com.epam.arrays.task1.service;

import com.epam.arrays.task1.entity.CustomArray;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class ArrayInitializationService {

    public CustomArray initializeWithConsole() {

        System.out.println("Enter length of array");
        int length;
        Scanner sc = new Scanner(System.in);
        length = sc.nextInt();
        int[] arr = new int[length];

        for (int i = 0; i < length; i++) {
            System.out.println("Enter " + i + " element");
            arr[i] = sc.nextInt();
        }

        return new CustomArray(arr);
    }

    public CustomArray initializeWithFile(String filePath) {

        String res = "";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                res += line;
            }
        } catch (FileNotFoundException fne) {
            fne.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        String[] strArr = res.split(", ");
        int[] arr = new int[strArr.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }

        return new CustomArray(arr);
    }

    public CustomArray initializeWithRandomNumbers(int arrLength, int from, int to) {
        int range = to - from;
        int[] arr = new int[arrLength];

        Random random = new Random();

        int tmp;
        for (int i = 0; i < arr.length; i++) {
            tmp = random.nextInt(range + 1);
            arr[i] = from + tmp;
        }

        return new CustomArray(arr);
    }
}
