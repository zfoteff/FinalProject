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
    }

    public void keyTyped(KeyEvent e)
    {
        System.out.println("Key pressed");
    }

    public void keyPressed(KeyEvent e)
    {
        int winner = 0;
        if (e.getKeyCode() == VK_A)
        {
            model.moveP1();

            winner = model.isWinner();
        }

        else if (e.getKeyCode() == VK_L)
        {
            model.moveP2();

            winner = model.isWinner();
        }

        if (winner == 1)
        {
            // p1 win condition
            int i = 0;
        }

        if (winner == 2)
        {
            // p2 win condition
            int i = 0;
        }
    }

    public void keyReleased(KeyEvent e)
    { return; }

    
}
