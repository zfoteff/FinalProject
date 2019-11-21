package build;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Background
{
    private int dx;
    private int x = -125;
    private int y = 0;
    private int w = 1000;
    private int h = 325;
    private Image image;

    public Background()
    {
        loadImage();
    }

    private void loadImage()
    {
        ImageIcon newImage = new ImageIcon("Untitled-1.jpeg");
        image = newImage.getImage();
        image = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
    }

    private void move()
    {
        x += dx;
    }

    public int getX()
    {
        return x;
    }


    public int getY()
    {
        return y;
    }

    public int getW()
    {
        return w;
    }

    public int getH()
    {
        return h;
    }

    public Image getImage()
    {
        return image;
    }
}
