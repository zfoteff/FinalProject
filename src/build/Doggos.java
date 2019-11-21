package build;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Doggos
{
    private int dx;
    private int x = 245;
    private int y = 90;
    private int w = 225;
    private int h = 150;
    private Image image;

    public Doggos()
    {
        loadImage();
    }

    private void loadImage()
    {
        ImageIcon newImage = new ImageIcon("doggos.png");
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

    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_A)
            dx = -2;

        if (key == KeyEvent.VK_D)
            dx = 2;
    }

    public void keyReleased(KeyEvent e)
    {
        move();
        dx = 0;
    }
}
