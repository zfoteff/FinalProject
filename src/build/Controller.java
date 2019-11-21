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

    public void keyTyped(KeyEvent e) { System.out.println("Key pressed"); }

    public void keyPressed(KeyEvent e)
    {
        int winner = 0;
        if (e.getKeyCode() == VK_A)
        {
            model.moveP1();
            view.graphicsPanel.repaint();

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
            model.p1Wins++;
            model.p2Losses++;
            view.win1Count.setText(""+model.p1Wins);
            view.loss2Count.setText(""+model.p2Losses);
        }

        if (winner == 2)
        {
            model.p1Losses++;
            model.p2Wins++;
            view.win2Count.setText(""+model.p2Wins);
            view.loss1Count.setText(""+model.p1Losses);
        }
    }

    public void keyReleased(KeyEvent e)
    { return; }

    
}
