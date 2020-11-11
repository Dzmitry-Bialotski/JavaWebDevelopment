package com.epam.oop_style_tasks.entity;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Point {");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append("} ");
        return sb.toString();
    }
}
