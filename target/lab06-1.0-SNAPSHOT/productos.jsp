<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Productos</title>
    <style>
        body { font-family: Arial; margin: 20px; }
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid #ccc; padding: 8px; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>
    <h2>Gestión de Productos</h2>
    <form action="productos" method="post">
        <input type="hidden" name="accion" value="agregar">
        Nombre: <input type="text" name="nombre" required>
        Precio: <input type="number" name="precio" step="0.01" required>
        <button type="submit">Agregar</button>
    </form>
    <hr>
    <h3>Lista</h3>
    <table>
        <tr><th>ID</th><th>Nombre</th><th>Precio</th><th>Acción</th></tr>
        <c:forEach var="producto" items="${productos}">
            <tr>
                <td>${producto.id}</td>
                <td>${producto.nombre}</td>
                <td>${producto.precio}</td>
                <td>
                    <form action="productos" method="post">
                        <input type="hidden" name="accion" value="eliminar">
                        <input type="hidden" name="id" value="${producto.id}">
                        <button type="submit">Eliminar</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
