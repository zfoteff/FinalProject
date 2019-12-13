/**
 * The GraphicsPanel for the code. It declares if there is a winner based on if the image is touching the side. It also
 * draws the images onto the panel
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

public class GraphicsPanel extends JPanel
{
    /**
     * Fields
     */
    protected View targetView;
    protected Background backgroundImage;
    protected Doggos players;

    /**
     *Constructor
     * @param view connects to the View
     */
    public GraphicsPanel(View view)
    {
        targetView = view;
        setBackground(Color.WHITE);
        backgroundImage = new Background();
        players = new Doggos();
        requestFocusInWindow();
    }

    /**
     *declares if there is a winner based on if it has touched the background edge
     */
    public int isWinner()
    {
        int backgroundRightEdge = backgroundImage.getW();
        int backgroundLeftEdge = 0;
        int playerPosition = players.getX();
        int playerWidth = players.getW();

        if (playerPosition <= backgroundLeftEdge)
            return 2;

        else if (playerPosition + playerWidth >= backgroundRightEdge)
            return 1;

        else
            return 0;
    }

    /**
     *resets the player position
     */
    public void reset()
    {
        players.resetPosition();
    }

    /**
     *draws the image by getting the background image and the player image
     */
    private void drawSprites(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(backgroundImage.getImage(), backgroundImage.getX(), backgroundImage.getY(), this);
        g2.drawImage(players.getImage(), players.getX(), players.getY(), this);
    }

    /**
     *the paint component that draws the sprites
     * @param g the graphics
     */
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        drawSprites(g);
    }
}
