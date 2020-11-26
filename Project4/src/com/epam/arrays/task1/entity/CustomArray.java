package com.epam.arrays.task1.entity;

import java.util.Arrays;
import java.util.List;

public class CustomArray {
    private int[] arr;

    public CustomArray(int... arr) {
        this.arr = arr;
    }

    public CustomArray(List<Integer> integerList) {
        arr = new int[integerList.size()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = integerList.get(i);
        }
    }

    public int getByIndex(int index) {
        if (!(index >= 0 && index < arr.length)) {
            throw new IndexOutOfBoundsException();
        }

        return arr[index];
    }

    public void setValueByIndex(int index, int value) {
        if (!(index >= 0 && index < arr.length)) {
            throw new IndexOutOfBoundsException();
        }

        arr[index] = value;
    }

    public int size(){
        return arr.length;
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomArray that = (CustomArray) o;

        return Arrays.equals(arr, that.arr);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(arr);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CustomArray{");
        sb.append("arr=").append(Arrays.toString(arr));
        sb.append('}');
        return sb.toString();
    }
}
