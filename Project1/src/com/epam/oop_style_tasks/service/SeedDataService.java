package com.epam.oop_style_tasks.service;

import com.epam.oop_style_tasks.entity.IFunctionable;

import java.util.ArrayList;

public class SeedDataService {
    public static ArrayList<Integer> seedArrayList()
    {
        ArrayList<Integer> array = new ArrayList<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        return array;
    }
    public static IFunctionable seedFunctionForTask8()
    {
        return (x) -> (x >= 3) ? ( - x * x + 3 * x + 9 ) : (1 / (Math.pow(x, 3) - 6));
    }
}
