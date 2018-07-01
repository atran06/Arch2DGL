package com.arthurtran.Arch2DGL.shape;

import com.arthurtran.Arch2DGL.main.Point;

public abstract class Shape {

    private float x;
    private float y;
    private float width;
    private float height;

    private double angle;

    public Shape(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Shape(Point point, float width, float height) {
        this.x = point.getX();
        this.y = point.getY();
        this.width = width;
        this.height = height;
    }

    public abstract void draw();
    public abstract void fill();
    public abstract void rotate(float deg);

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public double getAngle() {
        return angle;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}
