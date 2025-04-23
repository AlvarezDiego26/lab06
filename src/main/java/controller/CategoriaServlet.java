package controller;

import dao.CategoriaDAO;
import dao.CategoriaDAOImpl;
import model.Categoria;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/categorias")
public class CategoriaServlet extends HttpServlet {
    private CategoriaDAO categoriaDAO;

    @Override
    public void init() throws ServletException {
        categoriaDAO = new CategoriaDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Categoria> categorias = categoriaDAO.listarTodos();
        req.setAttribute("categorias", categorias);
        req.getRequestDispatcher("categorias.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");

        if ("agregar".equals(accion)) {
            String nombre = req.getParameter("nombre");
            Categoria categoria = new Categoria(0, nombre);
            categoriaDAO.agregar(categoria);
        } else if ("eliminar".equals(accion)) {
            int id = Integer.parseInt(req.getParameter("id"));
            categoriaDAO.eliminar(id);
        }

        resp.sendRedirect("categorias");
    }
}
