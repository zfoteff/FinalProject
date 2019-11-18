package build;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseTester {
        // database name
        static final String DATABASE_NAME = "highestScores";
        // connection url
        static final String CONNECTION_URL = "jdbc:sqlite:databases/" + DATABASE_NAME + ".db";
        static final String ID = "_id";
        static final String HIGHEST_SCORE = "highScores";
        static final String USER_NAME = "usersName";
        static final String CLICK_RATE = "clickRate";


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
                    USER_NAME + " TEXT, " +
                    CLICK_RATE + " TEXT)";
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
                    + "', '" + contact.getName() + "', '"
                    + contact.getClickRate() + "')";
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



    }

