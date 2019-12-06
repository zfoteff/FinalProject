package build;

import javax.swing.*;
import java.awt.*;

public class Doggos
{
    private final int DX = 100;
    private int x = 710;
    private int y = 185;
    private int w = 350;
    private int h = 200;
    private Image image;
    private boolean isFrozen = true;

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
        if (isFrozen)
            x = x;

        else
            x += DX;
    }

    public void moveLeft()
    {
        if (isFrozen)
            x = x;

        else
            x -= DX;
    }

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

    public void freeze(boolean freeze)
    {
        isFrozen = freeze;
    }
}
