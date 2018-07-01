package com.arthurtran.Arch2DGL.shape;

import org.lwjgl.opengl.GL11;

public class Rectangle extends Shape {

    private float x1, y1;
    private float x2, y2;
    private float x3, y3;
    private float x4, y4;
    private float originX, originY;

    public Rectangle(float x, float y, float width, float height) {
        super(x, y, width, height);

        x1 = this.getX();
        y1 = this.getY();

        x2 = this.getX() + this.getWidth();
        y2 = this.getY();

        x3 = this.getX() + this.getWidth();
        y3 = this.getY() + this.getHeight();

        x4 = this.getX();
        y4 = this.getY() + this.getHeight();
    }

    @Override
    public void draw() {
        GL11.glBegin(GL11.GL_LINE_LOOP);

        GL11.glVertex2f(x1, y1);
        GL11.glVertex2f(x2, y2);
        GL11.glVertex2f(x3, y3);
        GL11.glVertex2f(x4, y4);

        GL11.glEnd();
    }

    @Override
    public void fill() {
        GL11.glBegin(GL11.GL_QUADS);

        GL11.glVertex2f(x1, y1);
        GL11.glVertex2f(x2, y2);
        GL11.glVertex2f(x3, y3);
        GL11.glVertex2f(x4, y4);

        GL11.glEnd();
    }

    @Override
    public void rotate(float deg) {
        double rad = Math.toRadians((double) deg);

        float tempX1 = x1 - originX;
        float tempY1 = y1 - originY;
        float rotatedX1 = (tempX1 * (float) Math.cos(rad)) - (tempY1 * (float) Math.sin(rad));
        float rotatedY1 = (tempX1 * (float) Math.sin(rad)) + (tempY1 * (float) Math.cos(rad));
        x1 = rotatedX1 + originX;
        y1 = rotatedY1 + originY;

        float tempX2 = x2 - originX;
        float tempY2 = y2 - originY;
        float rotatedX2 = (tempX2 * (float) Math.cos(rad)) - (tempY2 * (float) Math.sin(rad));
        float rotatedY2 = (tempX2 * (float) Math.sin(rad)) + (tempY2 * (float) Math.cos(rad));
        x2 = rotatedX2 + originX;
        y2 = rotatedY2 + originY;

        float tempX3 = x3 - originX;
        float tempY3 = y3 - originY;
        float rotatedX3 = (tempX3 * (float) Math.cos(rad)) - (tempY3 * (float) Math.sin(rad));
        float rotatedY3 = (tempX3 * (float) Math.sin(rad)) + (tempY3 * (float) Math.cos(rad));
        x3 = rotatedX3 + originX;
        y3 = rotatedY3 + originY;

        float tempX4 = x4 - originX;
        float tempY4 = y4 - originY;
        float rotatedX4 = (tempX4 * (float) Math.cos(rad)) - (tempY4 * (float) Math.sin(rad));
        float rotatedY4 = (tempX4 * (float) Math.sin(rad)) + (tempY4 * (float) Math.cos(rad));
        x4 = rotatedX4 + originX;
        y4 = rotatedY4 + originY;

        if(getAngle() > 360) setAngle(0);
        else setAngle(getAngle() + 1);
    }
}
