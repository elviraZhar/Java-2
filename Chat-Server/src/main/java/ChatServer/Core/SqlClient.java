package ChatServer.Core;

import java.sql.*;

public class SqlClient {
    private static Connection connection;
    private static Statement statement;
    synchronized static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:Chat-Server/client-sqlite.db");
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    synchronized static void disconnect() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }
    synchronized static String getNick(String login, String password) {//для авторизации
        String query = String.format("select nikname from users where login='%s' and password='%s'", login, password);
        try (ResultSet set = statement.executeQuery(query)) {
            if (set.next())
                return set.getString("nickname");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
