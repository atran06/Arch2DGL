package com.arthurtran.Arch2DGL.shape;

import com.arthurtran.Arch2DGL.main.Point;
import org.lwjgl.opengl.GL11;

import java.util.LinkedList;

public class Triangle extends Shape {

    private LinkedList<Point> points;
    private float originX, originY;

    public Triangle(float x, float y, float width, float height) {
        super(x, y, width, height);

        points = new LinkedList<>();

        points.add(new Point(getX() + getWidth() / 2, getY()));
        points.add(new Point(getX(), getY() + getHeight()));
        points.add(new Point(getX() + getWidth(), getY() + getWidth()));

        originX = x + (width / 2);
        originY = y + (height / 2);
    }

    public Triangle(Point point, float width, float height) {
        super(point, width, height);

        points = new LinkedList<>();

        points.add(new Point(getX() + getWidth() / 2, getY()));
        points.add(new Point(getX(), getY() + getHeight()));
        points.add(new Point(getX() + getWidth(), getY() + getWidth()));

        originX = point.getX() + (width / 2);
        originY = point.getY() + (height / 2);
    }

    @Override
    public void draw() {
        GL11.glBegin(GL11.GL_LINE_LOOP);

        GL11.glVertex2f(points.get(0).getX(), points.get(0).getY());
        GL11.glVertex2f(points.get(1).getX(), points.get(1).getY());
        GL11.glVertex2f(points.get(2).getX(), points.get(2).getY());

        GL11.glEnd();
    }

    @Override
    public void fill() {
        GL11.glBegin(GL11.GL_TRIANGLES);

        GL11.glVertex2f(points.get(0).getX(), points.get(0).getY());
        GL11.glVertex2f(points.get(1).getX(), points.get(1).getY());
        GL11.glVertex2f(points.get(2).getX(), points.get(2).getY());

        GL11.glEnd();
    }

    @Override
    public void rotate(float deg) {
        double rad = Math.toRadians((double) deg);
        double originalAngle1 = Math.atan2((double) (points.get(1).getY() - originY),
                (double) (points.get(1).getX() - originX));

        float tempX1 = points.get(0).getX() - originX;
        float tempY1 = points.get(0).getY() - originY;
        float rotatedX1 = (tempX1 * (float) Math.cos(rad)) - (tempY1 * (float) Math.sin(rad));
        float rotatedY1 = (tempX1 * (float) Math.sin(rad)) + (tempY1 * (float) Math.cos(rad));
        points.get(0).setX(rotatedX1 + originX);
        points.get(0).setY(rotatedY1 + originY);

        float tempX2 = points.get(1).getX() - originX;
        float tempY2 = points.get(1).getY() - originY;
        float rotatedX2 = (tempX2 * (float) Math.cos(rad)) - (tempY2 * (float) Math.sin(rad));
        float rotatedY2 = (tempX2 * (float) Math.sin(rad)) + (tempY2 * (float) Math.cos(rad));
        points.get(1).setX(rotatedX2 + originX);
        points.get(1).setY(rotatedY2 + originY);

        float tempX3 = points.get(2).getX() - originX;
        float tempY3 = points.get(2).getY() - originY;
        float rotatedX3 = (tempX3 * (float) Math.cos(rad)) - (tempY3 * (float) Math.sin(rad));
        float rotatedY3 = (tempX3 * (float) Math.sin(rad)) + (tempY3 * (float) Math.cos(rad));
        points.get(2).setX(rotatedX3 + originX);
        points.get(2).setY(rotatedY3 + originY);

        if(getAngle() > 360) setAngle(0);
        else setAngle(getAngle() + 1);
    }
}
