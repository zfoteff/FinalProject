package build;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller
{
    Model model;
    ClientView view;
    private Timer timer;
    private final int DELAY = 1000;
    private int rightSideTimer = 0;
    private int leftSideTimer = 0;


    public Controller(Model m)
    {
        this.model = m;
        view = new ClientView(this);
        view.graphicsPanel.players.freeze(false);

        timer = new Timer(DELAY, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                incrementTimer();
                view.graphicsPanel.repaint();
            }
        });

        timer.start();
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

    public static void main(String[] args)
    {
        Model m = new Model();
        Controller c = new Controller(m);
    }
}
