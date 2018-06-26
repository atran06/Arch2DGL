package com.arthurtran.Arch2DGL.shape;

import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

public class Ellipse extends Shape {

    public Ellipse(float x, float y, float width, float height) {
        super(x, y, width, height);
    }

    @Override
    public void draw() {
        GL11.glBegin(GL11.GL_LINE_LOOP);

        for(int i = 0; i < 360; i++) {
            double angle = Math.toRadians(i);
            double xx = Math.cos(angle) * (getWidth() / 2);
            double yy = Math.sin(angle) * (getHeight() / 2);

            GL11.glVertex2d(getX() + xx + getWidth() / 2, getY() + yy + getHeight() / 2);
        }

        GL11.glEnd();
    }

    @Override
    public void fill() {
        GL11.glBegin(GL11.GL_LINE_STRIP);

        for(int i = 0; i < 360; i++) {
            double angle = Math.toRadians(i);
            double xx = Math.cos(angle) * (getWidth() / 2);
            double yy = Math.sin(angle) * (getHeight() / 2);

            GL11.glVertex2d(getX() + getWidth() / 2, getY() + getHeight() / 2);
            GL11.glVertex2d(getX() + xx + getWidth() / 2, getY() + yy + getHeight() / 2);
        }

        GL11.glEnd();
    }
}
