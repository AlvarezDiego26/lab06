<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Gestión de Productos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container py-5">
    <h2 class="mb-4">Gestión de Productos</h2>

    <form action="productos" method="post" class="row g-3 mb-4">
        <input type="hidden" name="accion" value="agregar">
        <div class="col-md-4">
            <label class="form-label">Nombre:</label>
            <input type="text" name="nombre" class="form-control" required>
        </div>
        <div class="col-md-4">
            <label class="form-label">Precio:</label>
            <input type="number" name="precio" step="0.01" class="form-control" required>
        </div>
        <div class="col-md-4 d-flex align-items-end">
            <button type="submit" class="btn btn-success w-100">Agregar Producto</button>
        </div>
    </form>

    <hr>

    <!-- Tabla de productos -->
    <h3 class="mb-3">Lista de Productos</h3>
    <table class="table table-bordered table-hover">
        <thead class="table-primary">
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Precio</th>
                <th>Acción</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="producto" items="${productos}">
                <tr>
                    <td>${producto.id}</td>
                    <td>${producto.nombre}</td>
                    <td>S/. ${producto.precio}</td>
                    <td>
                        <form action="productos" method="post" class="d-inline">
                            <input type="hidden" name="accion" value="eliminar">
                            <input type="hidden" name="id" value="${producto.id}">
                            <button type="submit" class="btn btn-sm btn-danger">Eliminar</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <a href="index.jsp" class="btn btn-outline-primary mt-3">Volver al Inicio</a>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
