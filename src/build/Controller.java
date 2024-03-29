/**
 * This is the Controller class. It has the keylisteners and connects most of the code logic together.
 * CPSC 224, Fall 2019
 *Final Project
 * No sources to cite.
 *
 * @author Kat Sotelo, Zac Foteff, Rebekah Hale
 * @version v1.0 12/12/19
 */

package build;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import static java.awt.event.KeyEvent.VK_A;
import static java.awt.event.KeyEvent.VK_L;

public class Controller implements KeyListener
{
    /**
     * fields
     */
    Model model;
    View view;
    protected String timerString;
    private final int DELAY = 1000;
    private int rightSideTimer = 0;
    private int leftSideTimer = 0;

    /**
     * Initializes the model and view. has action listeners for the timer and the reset buttons.
     * @param m , Model
     */
    public Controller(Model m)
    {
        this.model = m;
        view = new View(this);
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
                reset();
                resetTimerOnBoard();
            }
        });

        view.addKeyListener(this);
        view.timer.start();
    }

    /**
     * increments the timer with two fields, right side and leftside. The timer only goes up to 5 min
     */
    public void incrementTimer()
    {
        while (rightSideTimer != 60) {
            rightSideTimer++;
            String timerString = "0" + leftSideTimer + ":" + rightSideTimer;
            view.timerText.setText(timerString);
            if (rightSideTimer == 60) {
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

    /**
     * calls repaint when the key is pressed to update the view
     * @param e , the KeyEvent that occurs
     */
    @Override
    public void keyPressed(KeyEvent e)
    {
        view.graphicsPanel.repaint();
    }

    /**
     * This method has most of the game logic. It allows the players to move based on the key that was released
     * Also keeps track of who the winner is. If the winner is player 1 their scores and names goes to the database.
     * it also changes the view based on who won and loss.
     * @param e , the KeyEvent that occurs
     */
    @Override
    public void keyReleased(KeyEvent e)
    {

        // System.out.println("KEY PRESS");
        if (e.getKeyCode() == VK_A)
            view.graphicsPanel.players.moveRight();

        else if (e.getKeyCode() == VK_L)
            view.graphicsPanel.players.moveLeft();

        view.graphicsPanel.repaint();

        if (view.graphicsPanel.isWinner() == 1) {
            view.graphicsPanel.players.freeze(true);
            view.timer.stop();
            model.p1Wins++;
            model.p2Losses++;
            view.win1Count.setText("" + model.p1Wins);
            view.loss2Count.setText("" + model.p2Losses);

            String timer;
            timer = ""+leftSideTimer+": "+rightSideTimer;
            System.out.println("timer: " + timer);
            DataBaseContact contact = new DataBaseContact(timer, view.getP1S());
            System.out.println("p1: " + view.getP1S());
            System.out.println("Contact: " + contact);
            DataBaseTester test = new DataBaseTester();
            test.insertRecords(contact);
            List<DataBaseContact> records = test.ReadRecords();
            String bestScore = test.getUserHS(records, view.timerText.getText(), view.getP1S());
            String[] overAll = test.getOverAllHS(records, view.timerText.getText());
            view.best1Time.setText(bestScore);
            view.overallBestPlayer.setText(overAll[0]);
            view.overallBestTime.setText(overAll[1]);

            int choice = JOptionPane.showOptionDialog(null,
                    view.p1S + " wins! Play again?",
                    "Game Over", JOptionPane.YES_NO_OPTION, 0, null,
                    null, null);

            if (choice == JOptionPane.YES_OPTION) {
                resetTimerOnBoard();
                reset();
            } else
                System.exit(0);
        }

        else if(view.graphicsPanel.isWinner()==2)
        {
            view.graphicsPanel.players.freeze(true);
            view.timer.stop();
            model.p1Losses++;
            model.p2Wins++;
            view.loss1Count.setText("" + model.p1Losses);
            view.win2Count.setText("" + model.p2Wins);

            String timer;
            timer = ""+leftSideTimer+":"+rightSideTimer;
            System.out.println("timer: " + timer);
            DataBaseContact contact = new DataBaseContact(timer, view.getP2S());
            System.out.println("p2: " + view.getP2S());
            System.out.println("Contact: " + contact);
            DataBaseTester test = new DataBaseTester();
            test.insertRecords(contact);
            List<DataBaseContact> records = test.ReadRecords();
            String bestScore = test.getUserHS(records, view.timerText.getText(), view.getP2S());
            String[] overAll = test.getOverAllHS(records, view.timerText.getText());
            view.best2Time.setText(bestScore);
            view.overallBestPlayer.setText(overAll[0]);
            view.overallBestTime.setText(overAll[1]);

            int choice = JOptionPane.showOptionDialog(null,
                    view.p2S + " wins! Play again?",
                     "Game Over", JOptionPane.YES_NO_OPTION, 0, null,
                    null, null);

            if (choice == JOptionPane.YES_OPTION) {
                resetTimerOnBoard();
                reset();
        } else
            System.exit(0);


    }

}

    /**
     *resets the timer to be 0
     */
    public void resetTimer()
    {
        leftSideTimer = 0;
        rightSideTimer = 0;
    }

    /**
     *resets the graphic panel and calls repaint and allos the players to be able to move again
     */
    public void reset()
    {
        view.graphicsPanel.reset();
        view.graphicsPanel.repaint();
        view.requestFocusInWindow();
        view.graphicsPanel.players.freeze(false);
    }

    /**
     *resets the timer on the board
     */
    public void resetTimerOnBoard(){
        view.timer.restart();
        resetTimer();
    }

    /**
     *main that invokes the controller and starts the game
     */
    public static void main(String[] args)
    {
        Model m = new Model();
        Controller c = new Controller(m);
    }
}
