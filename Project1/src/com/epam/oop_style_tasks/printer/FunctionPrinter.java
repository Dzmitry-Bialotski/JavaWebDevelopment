package com.epam.oop_style_tasks.printer;

import com.epam.oop_style_tasks.entity.FunctionTable;
import com.epam.oop_style_tasks.entity.IFunctionable;

public class FunctionPrinter {
    public static void printFunction(double x, double y)
    {
        System.out.println("The value of function for x = " + x + " is " + y);
    }
    public static void printFunctionTable(FunctionTable ft)
    {
        System.out.println(ft);
    }
}
