package com.epam.oop_style_tasks.task5.service;

public class PerfectService {
    public boolean numberIsPerfect(int n) {
        int summa = 0;
        for(int i = 1; i < n; i++) {
            if(n % i == 0){
                summa += i;
            }
        }
        return summa == n ? true : false;
    }
}
