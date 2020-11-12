package com.epam.oop_style_tasks.task10.entity;

import java.util.ArrayList;

public class FunctionTable {
    private ArrayList<Double> arguments;
    private ArrayList<Double> values;

    public FunctionTable()
    {
        arguments = new ArrayList<>();
        values = new ArrayList<>();
    }
    public ArrayList<Double> getArguments() {
        return arguments;
    }

    public ArrayList<Double> getValues() {
        return values;
    }

    public void setArguments(ArrayList<Double> arguments) {
        this.arguments = arguments;
    }

    public void setValues(ArrayList<Double> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("==================================\n");
        sb.append("| \t x \t \t \t | \t y \t \t \t | \n");
        for(int i = 0; i < arguments.size(); i ++)
        {
            sb.append("| \t " + String.format("%.4f", arguments.get(i))  + " \t | \t "
                    + String.format("%.4f",  values.get(i)) + " \t | \n");
        }
        sb.append("==================================");
        return sb.toString();
    }
}
