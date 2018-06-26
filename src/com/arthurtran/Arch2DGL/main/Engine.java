package com.arthurtran.Arch2DGL.main;

import com.arthurtran.Arch2DGL.window.Window;
import org.lwjgl.glfw.GLFW;

import java.awt.*;

public interface Engine {

    void update();
    void render();

    default void runGameLoop(Window window) {
        window.init();
        window.initGL();

        boolean render;

        long beforeTime = System.nanoTime();
        long currentTime;
        long passedTime;
        long fps = 0;

        double ticks = 60.0; //per second
        double optimal = 1000000000 / ticks;
        double lastFPSTime = 0;
        double delta = 0;

        while (!GLFW.glfwWindowShouldClose(window.getWindow())) {
            render = false;
            currentTime = System.nanoTime();
            delta += (currentTime - beforeTime) / optimal;
            passedTime = currentTime - beforeTime;
            beforeTime = currentTime;

            while (delta >= 1) {
                render = true;
                update();
                Toolkit.getDefaultToolkit().sync();
                delta--;
            }

            lastFPSTime += passedTime;

            ///// Updates the FPS/////
            if (lastFPSTime >= 1000000000) {
                System.out.println("FPS: " + fps);
                window.transferFPS(fps);
                fps = 0;
                lastFPSTime = 0;
            }

            if (render) {
                render();
                fps++;
            }
        }
    }
}
