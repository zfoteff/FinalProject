/**
 * This is the model class that keeps track of the player 1 wins, the player 2 wins and both their losses
 * CPSC 224, Fall 2019
 *Final Project
 * No sources to cite.
 *
 * @author Kat Sotelo, Zac Foteff, Rebekah Hale
 * @version v1.0 12/12/19
 */
package build;

public class Model
{
    /**
     * Fields
     */
    public int p1Wins;
    public int p2Wins;
    public int p1Losses;
    public int p2Losses;

    /**
     *constructor
     */
    public Model()
    {
        p1Wins = 0;
        p2Wins = 0;
        p1Losses = 0;
        p2Losses = 0;
    }
}
