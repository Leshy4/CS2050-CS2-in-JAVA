package kochFlake;
/** CS 2050 - Computer Science II - Spring 2020
  * Description: Activity 13 - KochSnowflakeFrame class         */

import javax.swing.*;
import java.awt.*;

public class KochSnowflakeFrame extends JFrame {

    static final int WIDTH  = 1024;
    static final int HEIGHT = 600;

    KochSnowflakeFrame(int xStart, int yStart, int depth, double size, Color color) {
        setSize(WIDTH, HEIGHT);                                                 // Sets HxW of Frame
        setTitle("Koch's Snowflake");                                           //Title = Koch's Snowflake
        setContentPane(new KochSnowflake(xStart, yStart, depth, size, color));  // Shows in Content Pane
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                         // When Closed
        setBackground(Color.WHITE);                                             //Background = White
        setVisible(true);                                                       // Now you can see me!
    }

    public static void main(String[] args) {                                            // KOSH'S function call
        new KochSnowflakeFrame(300, 420, 3, 18, Color.BLACK);
//        new KochSnowflakeFrame(20, 20, 3, 20, Color.BLACK);
    }
}