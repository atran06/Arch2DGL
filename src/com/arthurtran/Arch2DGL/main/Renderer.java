package com.arthurtran.Arch2DGL.main;

import com.arthurtran.Arch2DGL.shape.Shape;
import com.arthurtran.Arch2DGL.window.Window;
import org.lwjgl.glfw.GLFW;

import static org.lwjgl.glfw.GLFW.GLFW_SAMPLES;
import static org.lwjgl.opengl.ARBImaging.glBlendEquation;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL14.GL_FUNC_ADD;

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

    public void setAA() {
        GLFW.glfwWindowHint(GLFW_SAMPLES, 4);
        glClear(GL_COLOR_BUFFER_BIT);
        glEnable(GL_BLEND);
        glBlendEquation(GL_FUNC_ADD);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glEnable(GL_LINE_SMOOTH);
        glEnable(GL_POINT_SMOOTH);
        glHint(GL_LINE_SMOOTH_HINT, GL_NICEST);
        glHint(GL_POINT_SMOOTH_HINT, GL_NICEST);
    }

    public void draw(Shape shape) {
        shape.draw();
    }

    public void fill(Shape shape) {
        shape.fill();
    }
}
