package com.epam.oop_style_tasks.task2.service;


import com.epam.oop_style_tasks.task2.entity.Month;

public class DateService {

    public static int getNumberOfDays(Month month, int year) {
        switch (month) {
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
    public static boolean yearIsLeap(int year) {
        return year%4 == 0 ? ( year%100 == 0 ? ((year%400 == 0) ? true : false ) : true) : false;
    }
}
