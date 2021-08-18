package ru.gb.java2.chat.server.chat.auth;

import java.sql.*;

public class JDBCAuthService implements IAuthService {

    private static final String DB_URL = "jdbc:sqlite:C:\\Users\\User\\Desktop\\математика\\geekbrains\\NetworkChat\\NetworkChatServer\\chat.db";
    // соединение с бд
    private static Connection connection;
    // запрос в БД
    String sql = ("SELECT username FROM users WHERE login = ?, password = ?");

    private PreparedStatement preparedStatement;

    @Override
    public void start() {
        // соединение с БД через DriverManager
        try {
            connection = DriverManager.getConnection(DB_URL);
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public String getUsernameByLoginAndPassword(String login, String password) {

        String username = null;

        try {
            // задать параметры запроса
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            // чтение результата
            while (resultSet.next()) {
                // тип колонки, название = resultSet.getТип(название колонки)
                username = resultSet.getString("username");
                break;
            }
            resultSet.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return username;
    }

    @Override
    public void stop() {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
