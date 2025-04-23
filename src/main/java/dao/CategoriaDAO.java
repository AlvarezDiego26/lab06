package dao;

import model.Categoria;
import java.util.List;

public interface CategoriaDAO {
    List<Categoria> listarTodos();
    void agregar(Categoria categoria);
    void eliminar(int id);
}
