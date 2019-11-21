package build;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;

public class GraphicsPanel extends JPanel
{
    protected ClientView targetView;
    protected Point start;
    protected Point end;
    protected Background backgroundImage;
    protected Doggos players;

    public GraphicsPanel(ClientView view)
    {
        targetView = view;
        setBackground(Color.WHITE);
        backgroundImage = new Background();
        players = new Doggos();
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
       // ImageIcon background = getScaledImage("Untitled-1.jpeg", 1000, 350);
        //backgroundImage.setIcon(background);

        super.paintComponent(g);

        drawSprites(g);
    }

    private void drawSprites(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(backgroundImage.getImage(), backgroundImage.getX(), backgroundImage.getY(), this);
        g2.drawImage(players.getImage(), players.getX(), players.getY(), this);
    }
}
