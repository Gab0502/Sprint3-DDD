package org.example.br.mediverso.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionService {
    private static final String URL = "jdbc:sqlite:src/main/java/org/example/br/mediverso/DAO/mediversoDb.sql";

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            System.out.println("Connection to SQLite failed: " + e.getMessage());
        }
        return connection;
    }
}
