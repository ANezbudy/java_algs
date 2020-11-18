package com.dtag.GenericTree;

import com.dtag.WFMTAT.BalancedTreeElement;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Screen {
    public static final int DIAMETER = 50;

    public static void main(String[] args) {
        drawSandBox();
    }

    public static void drawSandBox () {
//        final String title = "Dream House";
//        final int width = 1600;
//        final int height = width / 16 * 9;
//
//        //Creating the frame
//        JFrame frame = getFrame(title, width, height);
//
//        //Creating the canvas
//        Canvas canvas = getCanvas(width, height);
//
//        //Putting it all together
//        frame.add(canvas);
//
//        canvas.createBufferStrategy(3);
//
//        boolean running = true;
//
//        BufferStrategy bufferStrategy = canvas.getBufferStrategy();

        drawTheHause();


    }

    public static void drawTree(BalancedTreeElementGen root) {
        final String title = "Tree Graphics";
        final int width = 1600;
        final int height = width / 16 * 9;

        //Creating the frame
        JFrame frame = getFrame(title, width, height);

        //Creating the canvas

        Color backgroundColor = new Color(223, 214, 226);
        Canvas canvas = getCanvas(width, height, backgroundColor);

        //Putting it all together
        frame.add(canvas);

        canvas.createBufferStrategy(3);

//        boolean running = true;

        BufferStrategy bufferStrategy = canvas.getBufferStrategy();

        Graphics graphics = bufferStrategy.getDrawGraphics();


        Font font = new Font("Courier New", Font.PLAIN, 20);

        graphics.setFont(font);

        bufferStrategy.show();

        // parameters for tree layers
        int layerHeight = 100;
        int oneSlotLength = width - 100;

        BalancedTreeElementGen[] elementsOnLevel = new BalancedTreeElementGen[1];
        elementsOnLevel[0] = root;

        boolean nextIterationNeeded = true;
        int layerNo = 1;
        choseColor(19, 12, 154, graphics);


        while (nextIterationNeeded) {
            BalancedTreeElementGen[] elementsOnNextLevel = new BalancedTreeElementGen[elementsOnLevel.length*2];
            nextIterationNeeded = false;

            int y = layerHeight * layerNo;

            for (int i = 0; i < elementsOnLevel.length; i++) {

                BalancedTreeElementGen e = elementsOnLevel[i];
                int x = oneSlotLength/2 + i * oneSlotLength;

                int r = layerHeight - 10;


                if (e == null) {
//                    graphics.drawString("N", x, y);
                    elementsOnNextLevel[2*i] = null;
                    elementsOnNextLevel[2*i+1] = null;
                } else {
                    if (e.getLeftChildNode() != null) {
//                        graphics.drawLine(x, y, x + oneSlotLength/4, y + layerHeight);
                        graphics.drawLine(x, y, x - oneSlotLength/4, y + layerHeight);
                    }

                    if (e.getRightChildNode() != null) {
//                        graphics.drawLine(x, y, x - oneSlotLength/4, y + layerHeight);
                        graphics.drawLine(x, y, x + oneSlotLength/4, y + layerHeight);
                    }
                    graphics.setColor(backgroundColor);
                    graphics.fillOval(x - r /3, y - layerHeight/2, r, r);
                    choseColor(19, 12, 154, graphics);
                    graphics.drawOval(x - r /3, y - layerHeight/2, r, r);
                    graphics.drawString(e.getValue().toString(), x, y);
                    elementsOnNextLevel[i*2] = e.getLeftChildNode();
                    elementsOnNextLevel[i*2+1] = e.getRightChildNode();
                    nextIterationNeeded = nextIterationNeeded || e.getLeftChildNode() != null || e.getRightChildNode() != null;
                }
                bufferStrategy.show();
            }
            elementsOnLevel = elementsOnNextLevel;
            oneSlotLength = oneSlotLength/2;
            layerNo++;
        }
        while (true) {
            bufferStrategy.show();
        }


    }

    private static void drawTheHause () {
        final String title = "Dream House";
        final int width = 1600;
        final int height = width / 16 * 9;

        //Creating the frame
        JFrame frame = getFrame(title, width, height);

        //Creating the canvas

        Color color = new Color(223, 214, 226);
        Canvas canvas = getCanvas(width, height, color);

        //Putting it all together
        frame.add(canvas);

        canvas.createBufferStrategy(3);

        boolean running = true;

        BufferStrategy bufferStrategy = canvas.getBufferStrategy();

        while (running) {
            Graphics graphics = bufferStrategy.getDrawGraphics();

            // set personal print
            Font font = new Font("Arial", Font.PLAIN, 10);
            graphics.setFont(font);
            graphics.drawString("Nezbudii A", 10, 10);

            // draw sun
            choseColor(214, 18, 57, graphics);
            graphics.fillOval(1200, 100, 150, 100);




            // draw the land
            choseColor(242, 79, 0, graphics);
            for (int i = 0; i < 450; i++) {
                graphics.drawLine(0, 450 + i, 1600, 550 + i);
            }

            // draw the chimney
            choseColor(92, 75, 39, graphics);
            graphics.fillRect(460, 200, 50, 200);


            // draw the roof
            choseColor(134, 60, 57, graphics);

            for (int i = 0; i < 100; i++) {
                graphics.drawLine(400, 300 + i, 600, 400);
                graphics.drawLine(400, 300 + i, 200, 400);
            }

            // draw the lawn
            choseColor(0, 255, 0, graphics);
            graphics.fillOval(100, 550, 600, 100);

            // draw the building
            choseColor(122, 95, 69, graphics);
            graphics.fillRect(230, 400, 340, 180);

            // draw the door
            choseColor(71, 58, 31, graphics);
            graphics.fillArc(375, 480, 50, 200, 0, 180);

            // draw windows
            choseColor(92, 75, 39, graphics);
            graphics.fillOval(260, 425, 80, 80);
            graphics.fillOval(460, 425, 80, 80);

            choseColor(82, 255, 233, graphics);
            graphics.fillOval(265, 430, 70, 70);
            graphics.fillOval(465, 430, 70, 70);

            choseColor(92, 75, 39, graphics);
            graphics.drawLine(300, 425, 300, 505);
            graphics.drawLine(460, 465, 540, 465);

            // draw smoke
            choseColor(255, 0, 255, graphics);

            for (int i = 0; i < 180; i+=50) {
                graphics.fillArc(465, 170 - i, 50 + i, 40 + i, -20, 160);
            }

            bufferStrategy.show(); // show our drawing on screen
        }
    }

    private static Canvas getCanvas(int width, int height, Color color) {
        Canvas canvas = new Canvas();

        canvas.setSize(width, height);
        canvas.setBackground(color);
        canvas.setVisible(true);
        canvas.setFocusable(false);

        return canvas;
    }

    private static JFrame getFrame(String title, int width, int height) {
        JFrame frame = new JFrame(title);

        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        return frame;
    }

    private static void choseColor(int r, int g, int b, Graphics graphics) {
        Color color = new Color(r, g, b);
        graphics.setColor(color);
    }
}
