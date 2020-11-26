package com.epam.arrays.task2.entity;

import java.util.Arrays;

public class JaggedArray {

    private int[][] arr;

    public JaggedArray(int[]... rows) {
        arr = new int[rows.length][];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rows[i];
        }
    }

    public int[][] getArr() {
        return arr;
    }

    public void setArr(int[][] arr) {
        this.arr = arr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JaggedArray that = (JaggedArray) o;

        return Arrays.deepEquals(arr, that.arr);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(arr);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("JaggedArray{");
        sb.append("arr=").append(Arrays.toString(arr));
        sb.append('}');
        return sb.toString();
    }
}
