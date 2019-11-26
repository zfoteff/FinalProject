package build;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import static java.awt.event.KeyEvent.VK_A;
import static java.awt.event.KeyEvent.VK_L;

public class ClientView extends JFrame implements KeyListener
{
    protected JLabel win1Count;
    protected JLabel loss1Count;
    protected JLabel best1Time;
    protected JLabel win2Count;
    protected JLabel loss2Count;
    protected JLabel best2Time;
    protected JLabel timer;
    protected JLabel overallBestPlayer;
    protected JLabel overallBestTime;
    protected Controller controller;
    public GraphicsPanel graphicsPanel;
    public JLabel screen;

    public ClientView(Controller c){
        super("Fun Clicker Game");
        this.controller = c;
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setupUI();
        addKeyListener(this);
        pack();
    }

    public void setupUI(){
        //main panel
        JPanel panel = (JPanel) getContentPane();
        panel.setPreferredSize(new Dimension(900, 350));
        JPanel info = new JPanel();
        info.setPreferredSize(new Dimension(900, 100));
        panel.setLayout(new BorderLayout());

        graphicsPanel = new GraphicsPanel(this);

        //player 1 panel
        JPanel player1Panel = new JPanel();
        player1Panel.setBorder(BorderFactory.createTitledBorder("Player 1 Stats"));
        player1Panel.setLayout(new GridLayout(3,2));
        JLabel winLabel = new JLabel("Wins: ");
        player1Panel.add(winLabel);
        win1Count = new JLabel("0");
        player1Panel.add(win1Count);
        JLabel lossLabel = new JLabel("Losses: ");
        player1Panel.add(lossLabel);
        loss1Count = new JLabel("0");
        player1Panel.add(loss1Count);
        JLabel bestTimeLabel = new JLabel("Best time: ");
        player1Panel.add(bestTimeLabel);
        best1Time = new JLabel("0:00");
        player1Panel.add(best1Time);
        info.add(player1Panel);

        //timer panel
        JPanel timerPanel = new JPanel();
        timerPanel.setBorder(BorderFactory.createTitledBorder("Timer"));
        timerPanel.setLayout(new GridLayout(3,2));
        timer = new JLabel("0:00");
        timerPanel.add(timer);
        JLabel timerSpace = new JLabel();
        timerPanel.add(timerSpace);
        JLabel overallBestTimeLabel = new JLabel("Best time: ");
        timerPanel.add(overallBestTimeLabel);
        JLabel emptySpace = new JLabel();
        timerPanel.add(emptySpace);
        overallBestPlayer = new JLabel("Player");
        timerPanel.add(overallBestPlayer);
        overallBestTime = new JLabel("0:00");
        timerPanel.add(overallBestTime);
        info.add(timerPanel);

        //player2 panel
        JPanel player2Panel = new JPanel();
        player2Panel.setBorder(BorderFactory.createTitledBorder("Player 2 Stats"));
        player2Panel.setLayout(new GridLayout(3,2));
        JLabel win2Label = new JLabel("Wins: ");
        player2Panel.add(win2Label);
        win2Count = new JLabel("0");
        player2Panel.add(win2Count);
        JLabel loss2Label = new JLabel("Losses: ");
        player2Panel.add(loss2Label);
        loss2Count = new JLabel("0");
        player2Panel.add(loss2Count);
        JLabel bestTime2Label = new JLabel("Best time: ");
        player2Panel.add(bestTime2Label);
        best2Time = new JLabel("0:00");
        player2Panel.add(best2Time);
        info.add(player2Panel);;

        graphicsPanel.setVisible(true);
        graphicsPanel.requestFocusInWindow();

        panel.add(info, BorderLayout.NORTH);
        panel.add(graphicsPanel, BorderLayout.CENTER);
    }


    @Override
    public void keyTyped(KeyEvent keyEvent)
    {
       return;
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        System.out.println("KEY PRESS");
        if (e.getKeyCode() == VK_A)
            graphicsPanel.players.moveRight();

        else if (e.getKeyCode() == VK_L)
            graphicsPanel.players.moveLeft();

        graphicsPanel.repaint();
    }
}
