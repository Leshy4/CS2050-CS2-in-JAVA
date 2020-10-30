package kochFlake;
/** CS 2050 - Computer Science II - Spring 2020
  * Description: Activity 13 - KochSnowflake class           */

import javax.swing.*;
import java.awt.*;

public class KochSnowflake extends JPanel {
    private int    depth;
    private double size;
    private int    xPixel, yPixel;
    private double direction;           // Value in Degrees (NOT Radians!)
    private Color  color;

    static final int    MIN_DEPTH = 0;
    static final double MIN_SIZE  = 10;

    KochSnowflake(int xPixel, int yPixel, int depth, double size, Color color) {
        super();
        if (xPixel < 0)
            this.xPixel = 0;
        else
            this.xPixel = xPixel;   // if xPixel > 0
        if (yPixel < 0)             // if yPixel > 0
            this.yPixel = 0;
        else
            this.yPixel = yPixel;
        if (depth < MIN_DEPTH)      // if MIN_DEPTH > 0
            this.depth = MIN_DEPTH;
        else
            this.depth = depth;
        if (size < MIN_SIZE)        // if MIN_SIZE > 0
            this.size = MIN_SIZE;
        else
            this.size = size;
        direction = 0;       /** 0 degrees */
        this.color = color;
    }

    private void drawLine(Graphics g) {
        double directionRadians = Math.toRadians(direction);    // Degrees to Radians
        int xPixelNew = (int) Math.round( xPixel + Math.cos(directionRadians) * size); // (int) xPixel
        int yPixelNew = (int) Math.round( yPixel + Math.sin(directionRadians) * size); // (int) yPixel
        g.drawLine(xPixel, yPixel, xPixelNew, yPixelNew);
        xPixel = xPixelNew;
        yPixel = yPixelNew;
    }

    private void rotate(int degrees) {  direction += degrees; }

    private void drawCurve(Graphics g, int depth) {
        if (depth == 0) drawLine(g);    // base case
        else {
            drawCurve(g, depth - 1);    //Recursively Draw Top-Right
            rotate(60);
            drawCurve(g, depth - 1);    //Recursive Draw Bottom-Left
            rotate(-120);
            drawCurve(g, depth - 1);    //Recursively Draw Top-Right again
            rotate(60);
            drawCurve(g, depth - 1);    //Recursively until depth == 0
        }
    }

    private void drawSnowflake(Graphics g) {
        drawCurve(g, depth);    // Draw 120 Degrees
        rotate(-120);   // Rotate Clockwise 120 Degrees
        drawCurve(g, depth);
        rotate(-120);   // Rotate Clockwise 120 Degrees
        drawCurve(g, depth);   //  == 360 Degrees
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(color);  // Color of Snowflake
        drawSnowflake(g);   // Draw Snowflake
//        drawCurve(g, depth);
    }
}