package com.epam.ball_task.service;

import com.epam.ball_task.entity.Ball;
import com.epam.ball_task.entity.Basket;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import static org.testng.Assert.assertEquals;

public class BallServiceTest {

    @Test
    public void testCalculateWeightOfBalls() {
        Basket basket = new Basket();
        BallService ballService = new BallService();
        ArrayList<Ball> balls = new ArrayList<Ball>();
        Random random = new Random();
        balls.add( new Ball(1, Color.BLUE));
        balls.add( new Ball(2, Color.BLUE));
        balls.add( new Ball(3, Color.YELLOW));
        basket.setBalls(balls);

        double weight = ballService.calculateWeightOfBalls(basket);
        assertEquals(weight, 6.);
    }

    @Test
    public void testCalculateCountOfBlueBalls() {
        Basket basket = new Basket();
        BallService ballService = new BallService();
        ArrayList<Ball> balls = new ArrayList<Ball>();
        Random random = new Random();
        balls.add( new Ball(1, Color.BLUE));
        balls.add( new Ball(2, Color.BLUE));
        balls.add( new Ball(3, Color.YELLOW));
        basket.setBalls(balls);
        int count = ballService.calculateCountOfBlueBalls(basket);
        assertEquals(count, 2);
    }
}