package com.epam.oop_style_tasks.task4.service;


public class ArrayService {
    public boolean HasAtLeastTwoEvenNumbers(int[] nums) {
        int count = 0;
        for(int num : nums) {
            if(num%2 == 0){
                count++;
            }
            if(count >= 2){
                return true;
            }
        }
        return false;
    }
}
