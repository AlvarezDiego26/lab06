package dao;

import model.Producto;
import config.DatabaseConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAOImpl implements ProductoDAO {

    private Connection getConnection() throws SQLException {
        return DatabaseConfig.getConnection();
    }

    private void initDatabase() {
        String sql = "CREATE TABLE IF NOT EXISTS productos (" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                     "nombre TEXT NOT NULL, " +
                     "precio REAL NOT NULL)";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
        }
    }

    public ProductoDAOImpl() {
        initDatabase();
    }

    @Override
    public List<Producto> listarTodos() {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM productos";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                productos.add(new Producto(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getDouble("precio")
                ));
            }
        } catch (SQLException e) {
        }
        return productos;
    }

    @Override
    public void agregar(Producto producto) {
        String sql = "INSERT INTO productos (nombre, precio) VALUES (?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, producto.getNombre());
            stmt.setDouble(2, producto.getPrecio());
            stmt.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM productos WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
        }
    }
}
