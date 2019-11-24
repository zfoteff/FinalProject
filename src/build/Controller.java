package build;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.awt.event.KeyEvent.*;

public class Controller implements KeyListener
{
    Model model;
    ClientView view;

    public Controller(Model m)
    {
        this.model = m;
        view = new ClientView(this);

        view.graphicsPanel.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent keyEvent)
    {
        System.out.println("key typed");
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == VK_A)
            view.graphicsPanel.players.moveLeft();

        else if (e.getKeyCode() == VK_L)
            view.graphicsPanel.players.moveRight();

        view.graphicsPanel.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        view.graphicsPanel.repaint();
    }
}
