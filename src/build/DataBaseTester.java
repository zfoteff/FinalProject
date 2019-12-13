/**
 * This is the database tester class. It accesses the database using sqlite
 * CPSC 224, Fall 2019
 *Final Project
 * Dr. Gina Sprint's notes
 *
 * @author Kat Sotelo, Zac Foteff, Rebekah Hale
 * @version v1.0 12/12/19
 */

package build;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataBaseTester {
    // database name
    static final String DATABASE_NAME = "highestScores";
    // connection url
    static final String CONNECTION_URL = "jdbc:sqlite:databases/" + DATABASE_NAME + ".db";
    static final String ID = "_id";
    static final String HIGHEST_SCORE = "highScores";
    static final String USER_NAME = "usersName";
    protected List<DataBaseContact> nameList;


    /**
     *constructor
     */
    public DataBaseTester() {
        dataBaseConnector();
        createTable();
    }

    /**
     *connects to the database
     */
    public void dataBaseConnector() {
        try {
            Connection connect = DriverManager.getConnection(CONNECTION_URL);
            if (connect != null) {
                System.out.println("Successfully connected to the database");
                connect.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     *creates a table in the database
     */
    public void createTable() {
        String sqlCreate = "CREATE TABLE " + DATABASE_NAME + "(" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                HIGHEST_SCORE + " TEXT, " +
                USER_NAME + " TEXT)";
        try {
            Connection connect = DriverManager.getConnection(CONNECTION_URL);
            Statement stmt = connect.createStatement();
            // create a new table
            stmt.execute(sqlCreate);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            ;
        }

    }

    /**
     *inserts the Database Contact (with the username and highscore) into the database
     */
    public void insertRecords(DataBaseContact contact) {
        String sqlCreate = "INSERT INTO " + DATABASE_NAME
                + " VALUES(null, '" + contact.getHighScore()
                + "', '" + contact.getName() + "')";
        try {
            Connection connect = DriverManager.getConnection(CONNECTION_URL);
            Statement stmt = connect.createStatement();
            // create a new table
            stmt.execute(sqlCreate);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *Goes through the list of DatabaseContact and reads each contact
     */
    public List<DataBaseContact> ReadRecords() {
        nameList = new ArrayList<>();
        String sqlRead = "SELECT * FROM "
                + DATABASE_NAME;
        try {
            Connection connect = DriverManager.getConnection(CONNECTION_URL);
            Statement stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery(sqlRead);
            while (rs.next()) {
                String highestScore = rs.getString(HIGHEST_SCORE);
                String usersName = rs.getString(USER_NAME);
                DataBaseContact help = new DataBaseContact(highestScore, usersName);
                nameList.add(help);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return nameList;
    }

    /**
     *gets the user high score by comparing it to the last highscore
     */
    public String getUserHS(List<DataBaseContact> hsList, String newHS, String pName) {
        List<String> scores = new ArrayList<>();
        List<String> allNames = new ArrayList<>();

        for (DataBaseContact contact : hsList)
            if (contact.getName().equals(pName)) {
            Collections.sort(scores);
            Collections.sort(allNames);
            allNames.add(contact.getName());
            scores.add(contact.getHighScore());
            if (contact.getName().equals(pName)) {
                return contact.getName() + ":  " + scores.get(0);
            }
        }
        return "";
    }

    /**
     *gets the overall highscore by comparing it to the one in the database
     * @return String[] with the top player name and score
     */
    public String[] getOverAllHS(List<DataBaseContact> hsList, String newHS) {
        List<String> pName = new ArrayList<>();
        List<String> scores = new ArrayList<>();
        for (DataBaseContact contact: hsList) {
            Collections.sort(scores);
            Collections.sort(pName);
            scores.add(contact.getHighScore());
            pName.add(contact.getName());
        }

        String[] arr = {pName.get(0), scores.get(0)};

        return arr;
    }
}


