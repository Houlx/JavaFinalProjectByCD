package dao;

import java.sql.*;

/**
 * @author houlx
 *         Created by CD on 2017/7/12 18:06.
 */
public class Dao_CD {
    private String database;
    private Connection connection;
    private Statement statement;

    public Dao_CD(String database) {
        this.database = database;
    }

    public Dao_CD() {
    }

    private void connect() {
        connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(database);
            System.out.println("SUCCESSFULLY");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

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

    public ResultSet executeGet(String sql) {
        statement = null;
        ResultSet resultSet = null;
        connect();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return resultSet;
    }


}
