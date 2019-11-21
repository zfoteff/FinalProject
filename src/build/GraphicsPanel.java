package build;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;

public class GraphicsPanel extends JPanel
{
    protected ClientView targetView;
    protected Point start;
    protected Point end;
    protected Background backgroundImage;
    protected JLabel players;

    public GraphicsPanel(ClientView view)
    {
        targetView = view;
        setBackground(Color.WHITE);
        backgroundImage = new Background();
        players = new JLabel(getScaledImage("doggos.png", 300, 200));

        this.add(players);
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
    }

    public ImageIcon getScaledImage(String path, int w, int h)
    {
        ImageIcon screen = new ImageIcon(path);
        Image image = screen.getImage();
        Image screenFit = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        screen = new ImageIcon(screenFit);

        return screen;
    }
}
