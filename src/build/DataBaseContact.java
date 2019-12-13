/**
 * DatabaseContact is the database class that holds the fields for what the program writes into the database.
 * Program writes into the database the username and the highscore
 * CPSC 224, Fall 2019
 *Final Project
 * Dr. Gina Sprint's Directory
 *
 * @author Kat Sotelo, Zac Foteff, Rebekah Hale
 * @version v1.0 12/12/19
 */
package build;

public class DataBaseContact {
    /**
     *fields
     */
    private int id;
    private String usersName;
    private String highScore;

    /**
     *constructor
     */
    public DataBaseContact () {
        usersName = "";
        highScore = "";
    }

    /**
     *explicit value constructor
     */
    public DataBaseContact (String score, String user) {
        this.usersName = user;
        this.highScore = score;
    }

    /**
     *Creates a string representation
     */
    @Override
    public String toString () {
        return id + " " + usersName;
    }

    /**
     *gets the name of the username
     */
    public String getName () {
        return usersName;
    }

    /**
     *sets the username
     * @param name , string representative of the name of the user
     */
    public void setName (String name) {
        this.usersName = name;
    }

    /**
     *getter for the highscore
     */
    public String getHighScore () {
        return highScore;
    }

    /**
     *setter for the highscore
     * @param highScore , String representation of the highscore
     */
    public void setHighScore (String phoneNumber) {
        this.highScore = phoneNumber;
    }

    /**
     *getter for the ID
     */
    public int getId () {
        return id;
    }
}