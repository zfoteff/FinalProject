/**
 * This is the Background class. This class loads the background image
 * CPSC 224, Fall 2019
 *Final Project
 * No sources to cite.
 *
 * @author Kat Sotelo, Zac Foteff, Rebekah Hale
 * @version v1.0 12/12/19
 */

package build;
import javax.swing.*;
import java.awt.*;

public class Background
{
    /**
     *fields
     */
    private int x = 0;
    private int y = 0;
    private int w = 1750;
    private int h = 500;
    private Image image;

    /**
     *Constructor
     */
    public Background()
    {
        image = loadImage();
    }

    /**
     *loads the imageIcon
     */
    private Image loadImage()
    {
        ImageIcon newImage = new ImageIcon("Untitled-1.jpeg");
        image = newImage.getImage();
        image = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        return image;
    }

    /**
     *gets the x value of the image
     */
    public int getX()
    {
        return x;
    }

    /**
     *gets the y of the image
     */
    public int getY()
    {
        return y;
    }

    /**
     *gets the width of the image
     */
    public int getW()
    {
        return w;
    }

    /**
     *gets the image
     */
    public Image getImage()
    {
        return image;
    }
}
