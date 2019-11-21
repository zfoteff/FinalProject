package build;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;

public class GraphicsPanel extends JPanel
{
    ClientView targetView;
    Point start;
    Point end;
    JLabel backgroundImage;

    public GraphicsPanel(ClientView view)
    {
        targetView = view;
        setBackground(Color.WHITE);
        backgroundImage = new JLabel(getScaledImage());
        this.add(backgroundImage);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        ImageIcon background = getScaledImage();
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

    public ImageIcon getScaledImage()
    {
        ImageIcon screen = new ImageIcon("Untitled-1.jpeg");
        Image image = screen.getImage();
        Image screenFit = image.getScaledInstance(1000, 350, Image.SCALE_SMOOTH);
        screen = new ImageIcon(screenFit);

        return screen;
    }
}
