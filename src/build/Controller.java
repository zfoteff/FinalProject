package build;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.awt.event.KeyEvent.VK_A;
import static java.awt.event.KeyEvent.VK_L;

public class Controller implements KeyListener
{
    Model model;
    ClientView view;
    private final int DELAY = 1000;
    private int rightSideTimer = 0;
    private int leftSideTimer = 0;

    public Controller(Model m)
    {
        this.model = m;
        view = new ClientView(this);
        view.graphicsPanel.players.freeze(false);

        view.timer = new Timer(DELAY, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                incrementTimer();
                view.graphicsPanel.repaint();
            }
        });

        view.reset.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                view.graphicsPanel.reset();
                view.timer.restart();
                view.requestFocusInWindow();
            }
        });

        view.addKeyListener(this);
        view.timer.start();
    }

    public void incrementTimer()
    {
        while (rightSideTimer != 60)
        {
            rightSideTimer++;
            String timerString = "0"+leftSideTimer+":"+rightSideTimer;
            view.timerText.setText(timerString);
            if (rightSideTimer == 60)
            {
                rightSideTimer = 0;
                leftSideTimer++;
                if (leftSideTimer == 5)
                    break;

                break;
            }

            break;
        }
    }

    @Override
    public void keyTyped(KeyEvent keyEvent)
    {
        return;
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        view.graphicsPanel.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        System.out.println("KEY PRESS");
        if (e.getKeyCode() == VK_A)
            view.graphicsPanel.players.moveRight();

        else if (e.getKeyCode() == VK_L)
            view.graphicsPanel.players.moveLeft();


        view.graphicsPanel.repaint();

        if (view.graphicsPanel.isWinner())
        {
            view.graphicsPanel.players.freeze(true);
            view.timer.stop();
        }
    }

    public static void main(String[] args)
    {
        Model m = new Model();
        Controller c = new Controller(m);
    }
}
