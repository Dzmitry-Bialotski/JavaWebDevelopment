package com.epam.oop_style_tasks.task10.service;

import com.epam.oop_style_tasks.task10.entity.FunctionTable;
import com.epam.oop_style_tasks.task10.entity.IFunctionable;

public class FunctionService {
    public FunctionTable createFunctionTable(double a, double b, double h, IFunctionable function) {
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
