/**
 * This is the menu class that has the JOption dialog to set the player names at the beginning of the game
 * CPSC 224, Fall 2019
 *Final Project
 * No sources to cite.
 *
 * @author Kat Sotelo, Zac Foteff, Rebekah Hale
 * @version v1.0 12/12/19
 */
package build;

import javax.swing.*;
import java.util.List;

public class Menu
{
    View view;

    /**
     *shows the option dialog if the user wants to play a new game or quit
     */
    public int showMenu (View view)
    {
        String[] options = {"New Game", "Quit"};
        int choice = JOptionPane.showOptionDialog(view,
                "WELCOME TO BALL-IEVE IN YOUR SPEED!",
                "Menu", JOptionPane.YES_NO_OPTION, 0, null, options, options[0]);

        if (choice == JOptionPane.YES_OPTION)
            return 0;

        else if (choice == JOptionPane.NO_OPTION)
            return 1;

        return 0;
    }

    /**
     *option dialogs for entering the player names and sets the player names as well on the view
     * @param view gets the view.
     * @param p1Panel, panel for player 1 so you can set the name
     * @param p2Panel, panel for player 2 so you can set the name
     */
    public void enterPlayerNames (JPanel p1Panel, JPanel p2Panel, View view)
    {
        String pn1 = JOptionPane.showInputDialog("Enter Player1's Name: ");
        if (pn1.isEmpty()){
                view.setP1S("Player 1");
        }else{
            view.setP1S(pn1);
        }
        String pn2 = JOptionPane.showInputDialog("Enter Player2's Name: ");
        if (pn2.isEmpty()){
            view.setP2S("Player 2");
        }else{
            view.setP2S(pn2);
        }

        p1Panel.setBorder(BorderFactory.createTitledBorder(pn1));
        view.setP1S(pn1);
        view.setP2S(pn2);

        p2Panel.setBorder(BorderFactory.createTitledBorder(pn2));
        DataBaseTester db = new DataBaseTester();
        List<DataBaseContact> records = db.ReadRecords();
        String[] overAll = db.getOverAllHS(records, "");
        view.overallBestPlayer.setText(overAll[0]);
        view.overallBestTime.setText(overAll[1]);
    }
}
