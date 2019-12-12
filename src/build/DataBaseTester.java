package build;

import java.sql.*;
import java.util.ArrayList;
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


        public DataBaseTester () {
            dataBaseConnector();
            createTable();
        }

        public void dataBaseConnector () {
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

        public void createTable () {
            String sqlCreate = "CREATE TABLE " + DATABASE_NAME + "(" +
                    ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    HIGHEST_SCORE + " TEXT, " +
                    USER_NAME + " TEXT)";
            try {
                Connection connect = DriverManager.getConnection(CONNECTION_URL);
                Statement stmt = connect.createStatement();
                // create a new table
                stmt.execute(sqlCreate);
            }
            catch (SQLException e) {
                e.printStackTrace();
            }

        }

        public void insertRecords (DataBaseContact contact) {
            String sqlCreate = "INSERT INTO " + DATABASE_NAME
                    + " VALUES(null, '" + contact.getHighScore()
                    + "', '" + contact.getName() + "')";
            try{
                Connection connect = DriverManager.getConnection(CONNECTION_URL);
                Statement stmt = connect.createStatement();
                // create a new table
                stmt.execute(sqlCreate);
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }

    public List<DataBaseContact> ReadRecords () {
        nameList = new ArrayList<>();
        String sqlRead = "SELECT * FROM "
                + DATABASE_NAME;
        try {
            Connection connect = DriverManager.getConnection(CONNECTION_URL);
            Statement stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery(sqlRead);
            while (rs.next()) {
                String usersName = rs.getString(USER_NAME);
                String highestScore = rs.getString(HIGHEST_SCORE);
                DataBaseContact help = new DataBaseContact(usersName, highestScore);
                nameList.add(help);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return nameList;
    }
    public String getUserHS (List<DataBaseContact> nameList, int newHS, String pName) {
        for (DataBaseContact contact : nameList) {
            String temp = contact.getHighScore();
            int hs = Integer.parseInt(temp);
            if (pName.equals(contact.getName())){
                if (newHS < hs) {
                    return pName + ": " + temp;
                }
            }
        }
        return "";
    }
    public String getOverAllHS (List<DataBaseContact> hsList, int newHS, String pName) {
            for (DataBaseContact contact : hsList) {
                String temp = contact.getHighScore();
                int hs = Integer.parseInt(temp);
                if (newHS < hs) {
                    return pName + ": " + temp;
                }
            }
        return "";
    }

}

