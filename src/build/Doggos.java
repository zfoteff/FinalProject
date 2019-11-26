package build;

import javax.swing.*;
import java.awt.*;

public class Doggos
{
    private final int DX = 5;
    private int x = 400;
    private int y = 90;
    private int w = 175;
    private int h = 100;
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

    public void moveRight()
    {
        x += DX;
    }

    public void moveLeft() { x -= DX; }

    public int getX()
    {
        return x;
    }

    public int getY() { return y; }

    public int getW()
    {
        return w;
    }

    public Image getImage()
    {
        return image;
    }
}
