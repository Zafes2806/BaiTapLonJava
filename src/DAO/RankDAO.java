package DAO;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import model.Player;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import java.io.PrintWriter;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RankDAO {
    private static final String DB_SEVER_NAME = "ZAFES";
    private static final String DB_DATABASE_NAME = "PlayerRank";
    private static final String DB_USER_NAME = "sa";
    private static final String DB_PASSWORD = "12345678";

    public static List<Player> getRank() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Player> players = new LinkedList<>();
        try {
            connection = getConnection();

            String sql = "select playerName, playerScore " + "from PlayerRank "
                    + "order by playerScore desc, playDate desc";

            preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString(1);
                int score = rs.getInt(2);
                players.add(new Player(name, score));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return players;
    }

    public static boolean addPlayer(Player player) {
        boolean OK = false;

        int ID = getPlayerIDFromFile();
        if (ID == -1)
            return false;

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();

            String sql = "insert into PlayerRank Values(?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, ID);
            preparedStatement.setString(2, player.getName());
            preparedStatement.setInt(3, player.getScore());
            preparedStatement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            preparedStatement.executeUpdate();
            ID++;
            savePlayerIDToFile(ID);
            OK = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return OK;
    }

    public static void updateRank() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();

            String sql = "delete from PlayerRank where playerID not in ( " + "select top 5 playerId "
                    + "from PlayerRank " + "order by playerScore desc, playDate desc" + ")";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://" + DB_SEVER_NAME + ":1433;" + "databaseName=" + DB_DATABASE_NAME + ";"
                    + "encrypt = true; trustServerCertificate = true";

            connection = DriverManager.getConnection(url, DB_USER_NAME, DB_PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    private static int getPlayerIDFromFile() {
        int ID = -1;
        FileInputStream fileInputStream = null;
        BufferedReader bufferedReader = null;
        try {
            fileInputStream = new FileInputStream("resource/data/playerID.txt");
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            try {
                ID = Integer.parseInt(bufferedReader.readLine());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ID;
    }

    private static boolean savePlayerIDToFile(int ID) {
        boolean OK = false;
        FileWriter fileWriter = null;
        PrintWriter printWriter = null;
        try {
            fileWriter = new FileWriter("resource/data/playerID.txt");
            printWriter = new PrintWriter(fileWriter);
            printWriter.println(ID);
            OK = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (printWriter != null) {
                    printWriter.close();
                }
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return OK;
    }
}
