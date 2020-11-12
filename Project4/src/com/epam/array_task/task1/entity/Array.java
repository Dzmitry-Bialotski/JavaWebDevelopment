package com.epam.array_task.task1.entity;

import com.epam.array_task.task1.exception.CustomArrayException;

import java.util.Arrays;

public class Array {
    private int[] numbers;
    private int size;
    public Array(int size) {
        this.size = size;
        numbers = new int[size];
    }

    public int getSize() {
        return size;
    }
    public int getValue(int index){
        return numbers[index];
    }
    public void setValue(int index, int value){
        numbers[index] = value;
    }
    @Override
    public String toString() {
        return "Array{" +
                "numbers = " + Arrays.toString(numbers) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Array array = (Array) o;
        if(getSize() == array.getSize()){
            for(int i = 0; i < size; i ++){
                if(getValue(i) != array.getValue(i)){
                    return false;
                }
            }
        } else{
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(numbers);
    }
}
