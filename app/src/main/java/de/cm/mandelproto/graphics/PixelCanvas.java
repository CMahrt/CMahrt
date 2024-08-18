package de.cm.mandelproto.graphics;

import de.cm.mandelproto.math.IterationMap;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PixelCanvas extends JComponent {



    public PixelCanvas(int width, int height, IterationMap iterationMap) {
        super();
        this.iterationMap = iterationMap;
        setSize(width, height);
        setDoubleBuffered(true);
        image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        palette = new Color[255];
        for(int i=0; i< palette.length;i++){
            int r = (i) % 256;
            int g = (i) % 256;
            int b = (i) % 256;
            palette[i]=new Color(r,g,b);
        }
        drawImage();
    }

    private final BufferedImage image;
    private final IterationMap iterationMap;
    private final Color[] palette;


    @Override
    public void paint(Graphics g) {
        g.drawImage(image, 0, 0, this);
        super.paint(g);
    }

    public void drawImage() {
        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                image.setRGB(x, y, palette[iterationMap.getIterationForCoordinate(x,y)].getRGB());
            }
        }
        repaint();
    }


    public void draw(){
        long startTime = System.currentTimeMillis();
//        for (int i = 0; i < 50; i++) {
//            iterationMap.iterate();
//            step();
//        }
        iterationMap.tileIterate();
        drawImage();
        System.out.println("time to compute = " + (System.currentTimeMillis() - startTime) + " ms ");

    }
}
