package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {

    // Método estático para obtener la conexión a la base de datos
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.err.println("No se pudo cargar el driver de SQLite.");
        }

        String url = "jdbc:sqlite:C:/Users/Tecsup/Documents/NetBeansProjects/lab06/tienda.db";
        return DriverManager.getConnection(url);
    }
}
