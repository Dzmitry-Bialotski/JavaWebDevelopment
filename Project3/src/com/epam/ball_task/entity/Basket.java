package com.epam.ball_task.entity;

import java.util.ArrayList;
import java.io.*;
public class Basket implements Serializable{
    private ArrayList<Ball> balls;

    public Basket(){}

    public Basket(ArrayList<Ball> balls) {
        this.balls = balls;
    }

    public ArrayList<Ball> getBalls() {
        return balls;
    }

    public void setBalls(ArrayList<Ball> balls) {
        this.balls = balls;
    }

    public void addBall(Ball ball) {
        balls.add(ball);
    }

    public void addRangeOfBalls(ArrayList<Ball> balls){
        balls.addAll(balls);
    }

    public void RemoveBall(Ball ball){
        balls.remove(ball);
    }
    public void clear(){
        balls.clear();
    }

    public int count() {
        return balls.size();
    }

}
