package com.arthurtran.Arch2DGL.main;

import com.arthurtran.Arch2DGL.shape.Shape;
import com.arthurtran.Arch2DGL.window.Window;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL14;

public class Renderer {

    private Window window;

    public Renderer(Window window) {
        this.window = window;
    }

    public void initRender() {
        GLFW.glfwSwapBuffers(window.getWindow());
    }

    public void initUpdate() {
        GLFW.glfwPollEvents();
    }

    public void enableBlending() {
        GL11.glEnable(GL11.GL_BLEND);
        GL14.glBlendEquation(GL14.GL_FUNC_ADD);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
    }

    public void enableAA() {
        GLFW.glfwWindowHint(GLFW.GLFW_SAMPLES, 4);
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
        GL11.glEnable(GL11.GL_LINE_SMOOTH);
        GL11.glEnable(GL11.GL_POINT_SMOOTH);
        GL11.glEnable(GL11.GL_POLYGON_SMOOTH);
        GL11.glHint(GL11.GL_LINE_SMOOTH_HINT, GL11.GL_NICEST);
        GL11.glHint(GL11.GL_POINT_SMOOTH_HINT, GL11.GL_NICEST);
        GL11.glHint(GL11.GL_POLYGON_SMOOTH_HINT, GL11.GL_NICEST);
    }

    public void setColor(int color, float alpha) {
        if(color == A2D.A2D_RED) GL11.glColor4f(1, 0, 0, alpha);
        if(color == A2D.A2D_GREEN) GL11.glColor4f(0, 1, 0, alpha);
        if(color == A2D.A2D_BLUE) GL11.glColor4f(0, 0, 1, alpha);
        if(color == A2D.A2D_CYAN) GL11.glColor4f(0, 1, 1, alpha);
        if(color == A2D.A2D_MAGENTA) GL11.glColor4f(1, 0, 1, alpha);
        if(color == A2D.A2D_YELLOW) GL11.glColor4f(1, 1, 0, alpha);
        if(color == A2D.A2D_BLACK) GL11.glColor4f(0, 0, 0, alpha);
        if(color == A2D.A2D_WHITE) GL11.glColor4f(1, 1, 1, alpha);
    }

    public void setColorRGB(float r, float g, float b) {
        GL11.glColor3f(r / 255, g / 255, b / 255);
    }

    public void setColorRGBA(float r, float g, float b, float alpha) {
        GL11.glColor4f(r / 255, g / 255, b / 255, alpha);
    }

    public void draw(Shape shape) {
        shape.draw();
    }

    public void fill(Shape shape) {
        shape.fill();
    }
}
