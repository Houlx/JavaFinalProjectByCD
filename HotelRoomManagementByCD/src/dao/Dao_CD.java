package dao;

import java.sql.*;

/**
 * Dao Class, implementation of database operating method
 *
 * @author houlx
 *         Created by CD on 2017/7/12 18:06.
 */
public class Dao_CD {
    private String database = "jdbc:sqlite:/Users/houlx/IdeaProjects/JavaFinalProjectByCD/HotelRoomManagementByCD/hotel_management.sqlite";
    private Connection connection;
    private Statement statement;

    /**
     * constructor
     *
     * @param database url of database
     */
    public Dao_CD(String database) {
        this.database = database;
    }

    public Dao_CD() {
    }

    /**
     * close database connection
     */
    public void connectionClose() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * close statement
     */
    public void statementClose() {
        try {
            this.statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * package database connecting method
     */
    private void connect() {
        connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(database);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * execute INSERT, DELETE, UPDATE command
     *
     * @param sql sql operating command
     */
    public void executeSet(String sql) {
        statement = null;
        connect();
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * get ResultSet using SELECT command
     *
     * @param sql sql operating command
     * @return ResultSet
     */
    public ResultSet executeGet(String sql) {
        statement = null;
        ResultSet resultSet = null;
        connect();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }


}
