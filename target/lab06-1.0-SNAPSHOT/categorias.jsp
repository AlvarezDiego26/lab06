<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Lista de Categorías</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>
    <h2>Gestión de Categorías</h2>
    <form action="categorias" method="post">
        <input type="hidden" name="accion" value="agregar">
        <label>Nombre:</label>
        <input type="text" name="nombre" required>
        <button type="submit">Agregar Categoría</button>
    </form>

    <h3>Lista de Categorías</h3>
    <table>
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Acción</th>
        </tr>
        <c:forEach var="categoria" items="${categorias}">
            <tr>
                <td>${categoria.id}</td>
                <td>${categoria.nombre}</td>
                <td>
                    <form action="categorias" method="post">
                        <input type="hidden" name="accion" value="eliminar">
                        <input type="hidden" name="id" value="${categoria.id}">
                        <button type="submit">Eliminar</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
