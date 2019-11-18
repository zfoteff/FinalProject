/**
 * Created by gsprint
 */

public class DataBaseContact {
    private int id;
    private String usersName;
    private String highScore;
    private String clickRate;


    public DataBaseContact () {
        id = -1; //
        usersName = "";
        highScore = "";
        clickRate = "";
    }


    public DataBaseContact (int id, String user, String score, String clickRate) {
        this.id = id;
        this.usersName = user;
        this.highScore = score;
        this.clickRate = clickRate;
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

    public String getClickRate () {
        return clickRate;
    }

    public void setClickRate (String clickRate) {
        this.clickRate = clickRate;
    }

}