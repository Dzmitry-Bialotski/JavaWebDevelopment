package com.epam.ball_task.main;

import com.epam.ball_task.entity.Basket;
import com.epam.ball_task.printer.BallPrinter;
import com.epam.ball_task.service.BallService;

public class Main {
    public static void main(String[] args) {

        Basket basket = new Basket();
        BallService ballService = new BallService();
        ballService.seedBalls(basket);

        double weight = ballService.calculateWeightOfBalls(basket);
        int count = ballService.calculateCountOfBlueBalls(basket);

        BallPrinter ballPrinter = new BallPrinter();
        ballPrinter.printWeightOfBalls(weight);
        ballPrinter.printCountOfBlueBalls(count);
    }
}
