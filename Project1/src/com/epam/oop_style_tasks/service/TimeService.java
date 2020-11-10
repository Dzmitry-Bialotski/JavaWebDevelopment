package com.epam.oop_style_tasks.service;

import com.epam.oop_style_tasks.entity.Month;
public class TimeService {
    public static boolean yearIsLeap(int year)
    {
        if(year%4 == 0)
        {
            if(year%100 == 0)
            {
                if(year%400 == 0)
                {
                    return true;
                }
                return false;
            }
            return true;
        }
        else
        {
            return false;
        }
    }
    public static int getNumberOfDays(Month month, int year)
    {
        switch (month)
        {
            case JANUARY:
            case MARCH:
            case MAY:
            case JULY:
            case AUGUST:
            case OCTOBER:
            case DECEMBER:
                return 31;
            case APRIL:
            case JUNE:
            case SEPTEMBER:
            case NOVEMBER:
                return 30;
            case FEBRUARY:
                return yearIsLeap(year) ? 29 : 28;
            default:
                throw new IllegalArgumentException("Incorrect argument");
        }
    }
    public static int getFullHours(int seconds)
    {
        return seconds/3600;
    }
    public static int getFullMinutes(int seconds)
    {
        return seconds/60;
    }
}
