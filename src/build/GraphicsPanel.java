package build;
import javax.swing.*;
import java.awt.*;

public class GraphicsPanel extends JPanel
{
    protected ClientView targetView;
    protected Background backgroundImage;
    protected Doggos players;

    public GraphicsPanel(ClientView view)
    {
        targetView = view;
        setBackground(Color.WHITE);
        backgroundImage = new Background();
        players = new Doggos();
        requestFocusInWindow();
    }

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

    public void reset()
    {
        players.resetPosition();
    }

    private void drawSprites(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(backgroundImage.getImage(), backgroundImage.getX(), backgroundImage.getY(), this);
        g2.drawImage(players.getImage(), players.getX(), players.getY(), this);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        drawSprites(g);
    }
}
