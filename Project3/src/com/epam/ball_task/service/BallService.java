package com.epam.ball_task.service;

import com.epam.ball_task.entity.Ball;
import com.epam.ball_task.entity.Basket;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class BallService {
    public void seedBalls(Basket basket){
        ArrayList<Ball> balls = new ArrayList<Ball>();
        Random random = new Random();
        balls.add( new Ball(random.nextDouble(), Color.BLUE));
        balls.add( new Ball(random.nextDouble(), Color.BLUE));
        balls.add( new Ball(random.nextDouble(), Color.YELLOW));
        balls.add( new Ball(random.nextDouble(), Color.GREEN));
        balls.add( new Ball(random.nextDouble(), Color.RED));
        basket.setBalls(balls);
    }
    public double calculateWeightOfBalls(Basket basket){
        double weight = 0;
        for(Ball ball : basket.getBalls()){
            weight += ball.getWeight();
        }
        return weight;
    }
    public int calculateCountOfBlueBalls(Basket basket){
        int count = 0;
        for(Ball ball : basket.getBalls()){
            if(ball.getColor() == Color.BLUE){
                count ++;
            }
        }
        return count;
    }
}
