package com.arthurtran.Arch2DGL.main;

public class Light {

    private float x, y;
    private float radius;
    private float originX, originY;

    public Light(float x, float y, float radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;

        originX = radius + x;
        originY = radius + y;
    }

    public float getDistFromOrigin(int x, int y) {
        return (float) Math.sqrt((Math.pow(x - this.x, 2)) + (Math.pow(y - this.y, 2)));
    }

    public boolean isInside(int x, int y) {
        return getDistFromOrigin(x, y) < radius;
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

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public float getOriginX() {
        return originX;
    }

    public void setOriginX(float originX) {
        this.originX = originX;
    }

    public float getOriginY() {
        return originY;
    }

    public void setOriginY(float originY) {
        this.originY = originY;
    }
}
