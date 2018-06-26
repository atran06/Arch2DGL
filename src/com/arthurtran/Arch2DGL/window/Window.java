package com.arthurtran.Arch2DGL.window;

import com.arthurtran.Arch2DGL.main.A2D;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;

import org.lwjgl.opengl.GL11;

import org.lwjgl.system.MemoryUtil;

public class Window {

    private long window;

    private double width;
    private double height;
    private double scaleWidth;
    private double scaleHeight;

    private float scale;

    private int centered;
    private int vsync;
    private int fullscreen;

    private long fps;

    private String title;

    private GLFWVidMode videoMode;

    private boolean resizeable = false;

    public Window(double width, double height, String title, int centered, int vsync, float scale, int fullscreen) {
        this.width = width;
        this.height = height;

        this.title = title;

        this.centered = centered;
        this.vsync = vsync;
        this.fullscreen = fullscreen;

        this.scale = scale;
    }

    public void init() {
        if(!GLFW.glfwInit()) throw new IllegalStateException("Unable to initialize GLFW");

        if(resizeable) GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GLFW.GLFW_TRUE);
        else GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GLFW.GLFW_FALSE);

        videoMode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());

        scaleWidth = videoMode.width() / width;
        scaleHeight = videoMode.height() / height;

        if(fullscreen == A2D.A2D_FULLSCREEN) {
            window = GLFW.glfwCreateWindow((int) (width * scaleWidth),
                    (int) (height * scaleHeight), title, GLFW.glfwGetPrimaryMonitor(), MemoryUtil.NULL);
        }
        if(fullscreen == A2D.A2D_WINDOWED) {
            window = GLFW.glfwCreateWindow((int) (width * scale),
                    (int) (height * scale), title, MemoryUtil.NULL, MemoryUtil.NULL);
        }

        if(centered == A2D.A2D_CENTERED) GLFW.glfwSetWindowPos(window, videoMode.width() / 2 - (int) (width * scale) / 2,
                videoMode.height() / 2 - (int) (height * scale) / 2);

        if(vsync == A2D.A2D_TRUE) GLFW.glfwSwapInterval(1);
        else GLFW.glfwSwapInterval(0);

        GLFW.glfwMakeContextCurrent(window);
        GLFW.glfwShowWindow(window);
    }

    public void initGL() {
        GL.createCapabilities();

        if(fullscreen == A2D.A2D_FULLSCREEN) {
            GL11.glViewport(0, 0, (int) (width * scaleWidth), (int) (height * scaleHeight));
        } else {
            GL11.glViewport(0, 0, (int) (width * scale), (int) (height * scale));
        }
        GL11.glOrtho(0, width * scaleWidth, height * scaleHeight, 0, -1, 1);
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

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
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