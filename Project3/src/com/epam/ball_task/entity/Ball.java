package com.epam.ball_task.entity;

import java.awt.*;

public class Ball {
    private double weight;
    private Color color;

    public Ball(){};

    public Ball(double weight, Color color){
        this.weight = weight;
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }


}
