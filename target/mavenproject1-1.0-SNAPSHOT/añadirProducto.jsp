<%-- 
    Document   : añadirProducto
    Created on : 27-11-2024, 2:18:43 p. m.
    Author     : tobar
--%>

<%@page import="logica.Ropa"%>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ include file="/componentes/headerContent.jsp" %>
<link rel="stylesheet" href="css/styles.css"> 
<%@ include file="/componentes/head.jsp" %>
<%@ include file="/componentes/header.jsp" %>

<body id="editar-producto">
    <form action="AniadirProductoServlet" method="post">
        <div class="form-group">
            <label for="nombre">Nombre:</label>
            <input type="text" name="nombre" required>
        </div>

        <div class="form-group">
            <label for="descripcion">Descripción:</label>
            <input type="text" name="descripcion" required>
        </div>

        <div class="form-group">
            <label for="precio">Precio:</label>
            <input type="number" name="precio" required>
        </div>

        <div class="form-group">
            <label for="imagen">Imagen (URL):</label>
            <input type="url" name="imagen" required>
        </div>

        <div class="form-group">
            <label for="talla">Talla:</label>
            <input type="text" name="talla" required>
        </div>

        <div class="form-group">
            <label for="color">Color:</label>
            <input type="text" name="color" required>
        </div>

        <div class="form-group">
            <label for="tipo">Tipo:</label>
            <input type="text" name="tipo" required>
        </div>

        <div class="form-group">
            <label for="stock">Stock:</label>
            <input type="number" name="stock" required>
        </div>

        <input type="submit" value="Agregar Producto">
    </form>
</body>

<%@ include file="/componentes/footer.jsp" %>