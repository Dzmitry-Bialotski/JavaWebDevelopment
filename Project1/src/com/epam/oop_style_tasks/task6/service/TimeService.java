package com.epam.oop_style_tasks.task6.service;

public class TimeService {
    public int calculateFullHours(int seconds) {
        return seconds/3600;
    }
    public int calculateFullMinutes(int seconds) {
        return seconds/60;
    }
}
