package dao;

import model.Categoria;
import config.DatabaseConfig;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAOImpl implements CategoriaDAO {
    private Connection getConnection() throws SQLException {
        return DatabaseConfig.getConnection();
    }

    // Crear la tabla si no existe
    private void initDatabase() {
        String sql = "CREATE TABLE IF NOT EXISTS categorias (" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                     "nombre TEXT NOT NULL)";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
        }
    }

    public CategoriaDAOImpl() {
        initDatabase(); // Inicializar la tabla al crear el DAO
    }

    @Override
    public List<Categoria> listarTodos() {
        List<Categoria> categorias = new ArrayList<>();
        String sql = "SELECT * FROM categorias";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                categorias.add(new Categoria(
                    rs.getInt("id"),
                    rs.getString("nombre")
                ));
            }
        } catch (SQLException e) {
        }
        return categorias;
    }

    @Override
    public void agregar(Categoria categoria) {
        String sql = "INSERT INTO categorias (nombre) VALUES (?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, categoria.getNombre());
            stmt.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM categorias WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
        }
    }
}
