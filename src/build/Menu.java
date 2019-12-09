package build;

import javax.swing.*;

public class Menu
{
    public int showMenu ()
    {
        String[] options = {"New Game", "High Scores", "Quit"};
        int choice = JOptionPane.showOptionDialog(null,
                "WELCOME TO BALL-IEVE IN YOUR SPEED!",
                "Menu", JOptionPane.YES_NO_CANCEL_OPTION, 0, null, options, options[0]);

        if (choice == JOptionPane.YES_OPTION)
            return 0;

        else if (choice == JOptionPane.NO_OPTION)
            return 1;

        else if (choice == JOptionPane.CANCEL_OPTION)
            return 2;

        return 0;
    }

    public void enterPlayerNames (JPanel p1Panel, JPanel p2Panel)
    {
        String pn1 = JOptionPane.showInputDialog("Enter Player 1's Name: ");
        String pn2 = JOptionPane.showInputDialog("Enter Player 2's Name: ");
        p1Panel.setBorder(BorderFactory.createTitledBorder(pn1));
        p2Panel.setBorder(BorderFactory.createTitledBorder(pn2));
    }
}
