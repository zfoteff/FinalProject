/**
 * This is the Doggos class that loads the dog images and moves the dog icons DX pixels.
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

public class Doggos
{
    /**
     *fields
     */
    private final int DX = 100;
    private int x = 710;
    private int y = 185;
    private int w = 350;
    private int h = 200;
    private Image image;
    private boolean isFrozen = true;

    /**
     *constructor
     */
    public Doggos()
    {
        loadImage();
    }

    /**
     *loads the image into the panel
     */
    private void loadImage()
    {
        ImageIcon newImage = new ImageIcon("doggos.png");
        image = newImage.getImage();
        image = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
    }

    /**
     *moves the x to the right if it is not frozen
     */
    public void moveRight()
    {
        if (isFrozen)
            x = x;

        else
            x += DX;
    }

    /**
     *moves it to the left if it is not frozen
     */
    public void moveLeft()
    {
        if (isFrozen)
            x = x;

        else
            x -= DX;
    }

    /**
     *hardcoded to default to the original position
     */
    public void resetPosition()
    {
        this.x = 710;
        this.y = 185;
    }

    /**
     *getter for x
     */
    public int getX()
    {
        return x;
    }

    /**
     *getter for y
     */
    public int getY() { return y; }

    /**
     *getter for w
     */
    public int getW()
    {
        return w;
    }

    /**
     *getter for the image
     */
    public Image getImage()
    {
        return image;
    }

    /**
     *returns if it is frozen or not
     * @param freeze , boolean if true the photo is frozen else it can move
     */
    public void freeze(boolean freeze)
    {
        isFrozen = freeze;
    }
}
