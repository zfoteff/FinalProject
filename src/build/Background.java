package build;
import javax.swing.*;
import java.awt.*;

public class Background
{
    private int x = 0;
    private int y = 0;
    private int w = 1750;
    private int h = 500;
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

    public Image getImage()
    {
        return image;
    }
}
