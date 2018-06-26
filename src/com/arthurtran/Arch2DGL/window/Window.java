package com.arthurtran.Arch2DGL.window;

import com.arthurtran.Arch2DGL.main.A2D;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;

import org.lwjgl.opengl.GL11;

import org.lwjgl.system.MemoryUtil;

public class Window {

    private long window;

    private int width;
    private int height;
    private int centered;
    private int vsync;

    private long fps;

    private String title;

    private GLFWVidMode videoMode;

    private boolean resizeable = false;

    public Window(int width, int height, String title, int centered, int vsync) {
        this.width = width;
        this.height = height;

        this.title = title;

        this.centered = centered;
        this.vsync = vsync;
    }

    public void init() {
        if(!GLFW.glfwInit()) throw new IllegalStateException("Unable to initialize GLFW");

        if(resizeable) GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GLFW.GLFW_TRUE);
        else GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GLFW.GLFW_FALSE);

        window = GLFW.glfwCreateWindow(width, height, title, MemoryUtil.NULL, MemoryUtil.NULL);

        videoMode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
        if(centered == A2D.A2D_CENTERED) GLFW.glfwSetWindowPos(window, videoMode.width() / 2 - width / 2,
                videoMode.height() / 2 - height / 2);

        if(vsync == A2D.A2D_TRUE) GLFW.glfwSwapInterval(1);
        else GLFW.glfwSwapInterval(0);

        GLFW.glfwMakeContextCurrent(window);
        GLFW.glfwShowWindow(window);
    }

    public void initGL() {
        GL.createCapabilities();

        GL11.glViewport(0, 0, width, height);
        GL11.glOrtho(0, width, height, 0, -1, 1);
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glMatrixMode(GL11.GL_MODELVIEW);

        GL11.glDisable(GL11.GL_DEPTH_TEST);
    }

    public void transferFPS(long fps) {
        this.fps = fps;
    }

    public long getFps() {
        return this.fps;
    }

    public long getWindow() {
        return window;
    }

    public void setWindow(long window) {
        this.window = window;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getCentered() {
        return centered;
    }

    public void setCentered(int centered) {
        this.centered = centered;
    }

    public int getVsync() {
        return vsync;
    }

    public void setVsync(int vsync) {
        this.vsync = vsync;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public GLFWVidMode getVideoMode() {
        return videoMode;
    }

    public void setVideoMode(GLFWVidMode videoMode) {
        this.videoMode = videoMode;
    }

    public boolean isResizeable() {
        return resizeable;
    }

    public void setResizeable(boolean resizeable) {
        this.resizeable = resizeable;
    }
}