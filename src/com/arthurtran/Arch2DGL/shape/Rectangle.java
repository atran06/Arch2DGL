package com.arthurtran.Arch2DGL.shape;

import org.lwjgl.opengl.GL11;

public class Rectangle extends Shape {

    public Rectangle(float x, float y, float width, float height) {
        super(x, y, width, height);
    }

    public void draw() {
        GL11.glBegin(GL11.GL_LINE_LOOP);

        GL11.glVertex2f(this.getX(), this.getY());
        GL11.glVertex2f(this.getX() + this.getWidth(), this.getY());
        GL11.glVertex2f(this.getX() + this.getWidth(), this.getY() + this.getHeight());
        GL11.glVertex2f(this.getX(), this.getY() + this.getHeight());

        GL11.glEnd();
    }

    public void fill() {
        GL11.glBegin(GL11.GL_QUADS);

        GL11.glVertex2f(this.getX(), this.getY());
        GL11.glVertex2f(this.getX() + this.getWidth(), this.getY());
        GL11.glVertex2f(this.getX() + this.getWidth(), this.getY() + this.getHeight());
        GL11.glVertex2f(this.getX(), this.getY() + this.getHeight());

        GL11.glEnd();
    }
}
