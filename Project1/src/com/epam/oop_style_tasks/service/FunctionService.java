package com.epam.oop_style_tasks.service;

import com.epam.oop_style_tasks.entity.IFunctionable;
import com.epam.oop_style_tasks.entity.FunctionTable;

public class FunctionService {
    /*
    [a,b] - interval
    h - step
    */
    public static FunctionTable getFunctionTable(double a, double b, double h,  IFunctionable function)
    {
        FunctionTable functionTable = new FunctionTable();
        for(double x = a; x <= b; x += h)
        {
            functionTable.getArguments().add(x);
            double y = function.calculate(x);
            functionTable.getValues().add(y);
        }
        return functionTable;
    }
}
