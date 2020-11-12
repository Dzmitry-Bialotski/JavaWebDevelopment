package com.epam.oop_style_tasks.task1.service;

import com.epam.oop_style_tasks.task1.exception.DigitException;

public class DigitService {
    public int calculateLastDigitOfSquareNumber(int lastDigit) throws DigitException {
        if((lastDigit >= 0) && (lastDigit < 10)){
            return lastDigit * lastDigit % 10;
        }
        throw new DigitException("DigitException! Argument is not a digit!");
    };
}
