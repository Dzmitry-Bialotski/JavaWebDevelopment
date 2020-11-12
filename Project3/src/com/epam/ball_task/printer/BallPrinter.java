package com.epam.ball_task.printer;

public class BallPrinter {
    public void printWeightOfBalls(double weight){
        System.out.println("Total weight of balls is " + String.format("%.3f", weight));
    }
    public void printCountOfBlueBalls(int count){
        System.out.println("Total count of blue balls is " + count);
    }
}
