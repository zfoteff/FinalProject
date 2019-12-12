package build;

/**
 * Created by gsprint
 */

public class DataBaseContact {
    private int id;
    private String usersName;
    private String highScore;
    private String clickRate;


    public DataBaseContact () {
        usersName = "";
        highScore = "";
        clickRate = "";
    }


    public DataBaseContact (String user, String score) {
        this.usersName = user;
        this.highScore = score;
    }

    @Override
    public String toString () {
        return id + " " + usersName;
    }

    public String getName () {
        return usersName;
    }

    public void setName (String name) {
        this.usersName = name;
    }

    public String getHighScore () {
        return highScore;
    }

    public void setHighScore (String phoneNumber) {
        this.highScore = phoneNumber;
    }

}