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
    protected JLabel backgroundImage;
    protected JLabel players;

    public GraphicsPanel(ClientView view)
    {
        targetView = view;
        setBackground(Color.WHITE);
        backgroundImage = new JLabel(getScaledImage("Untitled-1.jpeg", 1000, 350));
        players = new JLabel(getScaledImage("doggos.png", 300, 200));
        
        this.add(backgroundImage);
        this.add(players);
        this.setComponentZOrder(backgroundImage, 0);
        this.setComponentZOrder(players, 1);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        ImageIcon background = getScaledImage("Untitled-1.jpeg", 1000, 350);
        backgroundImage.setIcon(background);

        super.paintComponent(g);
        if (start != null)
        {
            int x = start.x;
            int y = start.y;
            int w = Math.abs(start.x - end.x);
            int h = Math.abs(start.y - end.y);


        }
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
