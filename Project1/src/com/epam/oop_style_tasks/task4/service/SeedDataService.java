package com.epam.oop_style_tasks.task4.service;

import java.util.Random;

public class SeedDataService {
    public int[] createArray() {
        int size = 4;
        int nums[] = new int[4];
        Random random = new Random();
        for(int i = 0; i < 4; i++){
            nums[i] = random.nextInt(10);
        }
        return nums;
    }
    public int[] createArrayWithTwoEvenNumbers(){
        int size = 4;
        int nums[] = new int[size];
        Random random = new Random();
        nums[0] = 2;
        nums[1] = 4;
        for(int i = 2; i < size; i++){
            nums[i] = random.nextInt(10);
        }
        return nums;
    }
}
