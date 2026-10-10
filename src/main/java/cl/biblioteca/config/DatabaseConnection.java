package cl.biblioteca.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** Singleton responsable de centralizar los parámetros y abrir conexiones JDBC. */
public final class DatabaseConnection {
    private static volatile DatabaseConnection instance;
    private final String url, user, password;
    private DatabaseConnection() {
        url = System.getenv().getOrDefault("BIBLIOTECA_DB_URL", "jdbc:mysql://localhost:3306/biblioteca_escolar?serverTimezone=America/Santiago&useSSL=false&allowPublicKeyRetrieval=true");
        user = System.getenv().getOrDefault("BIBLIOTECA_DB_USER", "root");
        password = System.getenv().getOrDefault("BIBLIOTECA_DB_PASSWORD", "");
    }
    public static DatabaseConnection getInstance() {
        if (instance == null) synchronized (DatabaseConnection.class) {
            if (instance == null) instance = new DatabaseConnection();
        }
        return instance;
    }
    public Connection getConnection() throws SQLException { return DriverManager.getConnection(url, user, password); }
}
