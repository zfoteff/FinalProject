package build;
import javax.swing.*;
import java.awt.*;

public class View extends JFrame
{
    protected JLabel win1Count;
    protected JLabel loss1Count;
    protected JLabel best1Time;
    protected JLabel win2Count;
    protected JLabel loss2Count;
    protected JLabel best2Time;
    protected JLabel timerText;
    protected JLabel overallBestPlayer;
    protected JLabel overallBestTime;
    protected JButton reset = new JButton("Reset");
    protected Controller controller;
    public Timer timer;
    public GraphicsPanel graphicsPanel;
    protected String p2S;
    protected String p1S;

    public View(Controller c)
    {
        super("Fun Clicker Game");
        this.controller = c;
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setupUI();
        pack();
    }

    public void setupUI()
    {
        //main panel
        JPanel panel = (JPanel) getContentPane();
        panel.setPreferredSize(new Dimension(1750, 600));
        panel.setLayout(new BorderLayout());

        //  info panel
        //  - contains: player info panel, timer, reset button
        JPanel info = new JPanel();
        info.setPreferredSize(new Dimension(900, 100));
        info.setLayout(new BoxLayout(info, BoxLayout.PAGE_AXIS));
        graphicsPanel = new GraphicsPanel(this);
        graphicsPanel.setVisible(true);
        graphicsPanel.requestFocusInWindow();

        //  player info panel
        //  - contains: player 1 wins and losses, player 2 wins and losses
        JPanel playerInfo = new JPanel();
        playerInfo.setPreferredSize(new Dimension(900, 80));

        //player 1 panel
        JPanel player1Panel = new JPanel();
        player1Panel.setBorder(BorderFactory.createTitledBorder("Player 1 Stats"));
        player1Panel.setLayout(new GridLayout(3,2));
        JLabel win1Label = new JLabel("Wins: ");
        win1Count = new JLabel("0");
        JLabel lossLabel = new JLabel("Losses: ");
        loss1Count = new JLabel("0");
        JLabel bestTimeLabel = new JLabel("Best time: ");
        best1Time = new JLabel("0:00");
        player1Panel.add(win1Label);
        player1Panel.add(win1Count);
        player1Panel.add(lossLabel);
        player1Panel.add(loss1Count);
        player1Panel.add(bestTimeLabel);
        player1Panel.add(best1Time);

        //timer panel
        JPanel timerPanel = new JPanel();
        timerPanel.setBorder(BorderFactory.createTitledBorder("Timer"));
        timerPanel.setLayout(new GridLayout(3,2));
        timerText = new JLabel("0:00");
        JLabel timerSpace = new JLabel();
        JLabel overallBestTimeLabel = new JLabel("Best time: ");
        JLabel emptySpace = new JLabel();
        overallBestPlayer = new JLabel("Player");
        overallBestTime = new JLabel("0:00");
        timerPanel.add(timerText);
        timerPanel.add(timerSpace);
        timerPanel.add(overallBestTimeLabel);
        timerPanel.add(emptySpace);
        timerPanel.add(overallBestPlayer);
        timerPanel.add(overallBestTime);

        //player2 panel
        JPanel player2Panel = new JPanel();
        player2Panel.setBorder(BorderFactory.createTitledBorder("Player 2 Stats"));
        player2Panel.setLayout(new GridLayout(3,2));
        JLabel win2Label = new JLabel("Wins: ");
        win2Count = new JLabel("0");
        JLabel loss2Label = new JLabel("Losses: ");
        loss2Count = new JLabel("0");
        JLabel bestTime2Label = new JLabel("Best time: ");
        best2Time = new JLabel("0:00");
        player2Panel.add(win2Label);
        player2Panel.add(win2Count);
        player2Panel.add(best2Time);
        player2Panel.add(loss2Label);
        player2Panel.add(loss2Count);
        player2Panel.add(bestTime2Label);
        player2Panel.add(best2Time);

        playerInfo.add(player1Panel);
        playerInfo.add(timerPanel);
        playerInfo.add(player2Panel);

        info.add(playerInfo);
        info.add(reset);

        panel.add(info, BorderLayout.NORTH);
        panel.add(graphicsPanel, BorderLayout.CENTER);


        Menu menu = new Menu();
        int choice = menu.showMenu(this);

        while (choice != 0)
        {
            if (choice == 2)
                System.exit(0);

            //  access database here
            choice = menu.showMenu(this);
        }
        menu.enterPlayerNames(player1Panel, player2Panel,this);
        System.out.println(p2S + p2S);
    }

    public String getP1S() {
        return p1S;
    }

    public String getP2S() {
        return p2S;
    }

    public void setP1S(String p1S) {
        this.p1S = p1S;
    }

    public void setP2S(String p2S) {
        this.p2S = p2S;
    }
}
